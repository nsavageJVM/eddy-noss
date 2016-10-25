package eddy.noss.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ubu on 25.10.16.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SimpleMicroClient {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SimpleMicroClient.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }


}
