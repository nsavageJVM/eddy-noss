package eddy.noss.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Registry {

    public static void main(String[] args) {
        SpringApplication registry = new SpringApplication(Registry.class);
        registry.addListeners(new ApplicationPidFileWriter("registry.pid"));
        registry.run(args);
    }

}
