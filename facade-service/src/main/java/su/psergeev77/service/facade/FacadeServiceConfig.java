package su.psergeev77.service.facade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class FacadeServiceConfig extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(FacadeServiceConfig.class, args);
    }

}
