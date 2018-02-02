package su.psergeev77.service.facade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableFeignClients
public class FacadeServiceConfig extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(FacadeServiceConfig.class, args);
    }

//    @Bean
//    public Decoder feignDecoder() {
//        ObjectMapper mapper = new ObjectMapper()
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                .registerModule(new Jackson2HalModule());
//
//        return new ResponseEntityDecoder(new JacksonDecoder(mapper));
//    }

}
