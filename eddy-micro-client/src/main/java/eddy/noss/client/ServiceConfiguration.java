package eddy.noss.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * Created by ubu on 25.10.16.
 *  * will be used for all clients as is in component scan
 */
@Configuration
public class ServiceConfiguration {

    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}
