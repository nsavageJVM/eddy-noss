package eddy.noss.simplemicro;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class SimpleMicro {

    private static final Logger log = LoggerFactory.getLogger(SimpleMicro.class);

    @Autowired
    DiscoveryClient discoveryClient;

    RestTemplate restTemplate = new RestTemplate();


    public static void main(String[] args) {
        SpringApplication notificationMicroService = new SpringApplication(SimpleMicro.class);
        notificationMicroService.addListeners(new ApplicationPidFileWriter("SimpleMicro.pid"));
        notificationMicroService.run(args);
    }


    @RequestMapping("/")
    String home() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("SMICROSERVER", false);
        String homePageUrl = instance.getHomePageUrl();

        log.info("Got homepage url {}", homePageUrl);

        ResponseEntity<String> response = restTemplate.getForEntity(homePageUrl, String.class);


        return "SimpleMicroServer notification " + response.getBody() ;
    }

    @RequestMapping("/debug")
    String debug() {

        return "SimpleMicroServer notification debug"  ;
    }


}
