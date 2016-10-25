package eddy.noss.micros.hystrix;

import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by ubu on 24.10.16.
 */
@RequestMapping(value = "/status")
@RestController
public class ServiceStatusController {


    @Autowired
    private StatusService statusService;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HystrixRuntimeException.class)
    public String handleBadRequest(Exception ex) {
        return ex.getMessage();
    }


    @RequestMapping(value = "/smicro", method = RequestMethod.GET)
    public InstanceStatus microStatus() {
        return statusService.baseMicroStatus();
    }


    @RequestMapping(value = "/microserver", method = RequestMethod.GET)
    public InstanceStatus microserverStatus() {
        return statusService.baseMicroStatus();
    }


}
