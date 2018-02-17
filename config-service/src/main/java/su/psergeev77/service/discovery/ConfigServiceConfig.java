package su.psergeev77.service.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class ConfigServiceConfig {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceConfig.class, args);
    }

}
