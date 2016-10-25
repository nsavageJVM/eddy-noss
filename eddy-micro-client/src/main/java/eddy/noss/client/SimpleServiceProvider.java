package eddy.noss.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by ubu on 25.10.16.
 */

@FeignClient(value = "smicroserver")
public interface SimpleServiceProvider {

    @RequestMapping(value = "/feign", method = GET)
    String getFeignEndpoint();

}
