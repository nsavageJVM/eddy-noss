package eddy.noss.micros.hystrix;

import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ubu on 24.10.16.
 */
@Component
public class StatusService {

    private static final Logger log = LoggerFactory.getLogger(StatusService.class);
    private static final String BASE_SERVICE_NAME = "S-MICRO";
    private static final String SERVER_SERVICE_NAME = "SMICROSERVER";


    @Autowired
    private DiscoveryClient discoveryClient;


    @HystrixCommand(groupKey = "base-micro-service", fallbackMethod = "baseMicroStatusNotFound")
    public InstanceStatus baseMicroStatus() {
        return discoveryClient.getNextServerFromEureka(BASE_SERVICE_NAME, false)
                .getStatus();
    }

    public InstanceStatus baseMicroStatusNotFound() {
        return InstanceStatus.DOWN;
    }


    @HystrixCommand(groupKey = "micro-server", fallbackMethod = "microSevStatusNotFound")
    public InstanceStatus microSevStatus() {
        return discoveryClient.getNextServerFromEureka(SERVER_SERVICE_NAME, false)
                .getStatus();
    }

    public InstanceStatus microSevStatusNotFound() {
        return InstanceStatus.DOWN;
    }


}
