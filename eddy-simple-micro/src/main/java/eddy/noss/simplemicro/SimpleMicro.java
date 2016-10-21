package eddy.noss.simplemicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //or @EnableDiscoveryClient
public class SimpleMicro {

    public static void main(String[] args) {
        SpringApplication notificationMicroService = new SpringApplication(SimpleMicro.class);
        notificationMicroService.addListeners(new ApplicationPidFileWriter("SimpleMicro.pid"));
        notificationMicroService.run(args);
    }
}
