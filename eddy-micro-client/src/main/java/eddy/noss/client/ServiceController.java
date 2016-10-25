package eddy.noss.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by ubu on 25.10.16.
 */
@RestController
public class ServiceController {

    @Autowired
    SimpleServiceProvider serviceProvider;

    @Autowired
    private ExternalServiceProvider externalServiceProvider;

    @RequestMapping(value = "/server-client-feign", method = RequestMethod.GET )
    public String getCustomer( ) {

        return   serviceProvider.getFeignEndpoint();
    }

    @RequestMapping(value = "/ext-client-feign", method = GET)
    public String getRates() {

        if(Objects.isNull(externalServiceProvider)) {
            return "service provider is null ";
        }
       String result =  externalServiceProvider.echo();

        if(Objects.isNull(result)) {
            return "service provider result is null ";
        }

        return externalServiceProvider.echo();


    }
}
