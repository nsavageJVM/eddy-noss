package eddy.noss.simpleserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ubu on 24.10.16.
 */

@SpringBootApplication
@RestController
@EnableEurekaClient
public class SimpleMicroServer {

    public static void main(String[] args) {
        SpringApplication simpleMicroServer = new SpringApplication(SimpleMicroServer.class);
        simpleMicroServer.addListeners(new ApplicationPidFileWriter("SimpleMicroServer.pid"));
        simpleMicroServer.run(args);
    }



    @RequestMapping("/")
    public String home() {
        return "This is a trivial service that demonstrates how a Eureka Client\n " +
                "can register with a Eureka Server and discover services";
    }

    @RequestMapping(value = "/feign", method = RequestMethod.GET)
    public String feignRestEndPoint() {
        return "This is a trivial endpoint that demonstrates how a Eureka Client\n " +
                "can register with a Eureka Server and provide services to a Feign rest client";
    }


}
