package java_spring.jobms.job;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class AppConfig {
    @Bean          //tell Spring framework that it needs to manage the object of the class
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
