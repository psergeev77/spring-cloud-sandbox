package su.psergeev77.service.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import su.psergeev77.service.client.model.Client;
import su.psergeev77.service.client.repository.ClientRepository;

import java.util.Arrays;

@SpringBootApplication
public class ClientServiceConfig {
    public static void main(String[] args) {
        SpringApplication.run(ClientServiceConfig.class, args);
    }
    @Bean
    CommandLineRunner init(ClientRepository accountRepository) {

        final Client[] testClients = { new Client("jhoeller","Liam","Smith","jhoeller@gmail.com"),
        new Client("dsyer","Emma","Johnson","dsyer1@yandex.ru"),
        new Client("pwebb","Noah","Williams","pwebb@mail.ru"),
        new Client("ogierke","Mason","Jones","ogierke@hotmail.com"),
        new Client("rwinch","Olivia","Brown","rwinch@abc.org")};

        return (evt) -> Arrays.asList(testClients).forEach(a -> accountRepository.save(a));
    }
}
