package eddy.noss.micros.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAsync
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@RestController
public class SimpleMicroHystrix {


    @Autowired
    private ErrorAttributes errorAttributes;



    public static void main(String[] args) {
        SpringApplication notificationMicroService = new SpringApplication(SimpleMicroHystrix.class);
        notificationMicroService.addListeners(new ApplicationPidFileWriter("SimpleMicroHystrix.pid"));
        notificationMicroService.run(args);
    }

    @Bean
    public AppErrorController appErrorController(){return new AppErrorController(errorAttributes);}



}
