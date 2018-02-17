package su.psergeev77.service.post;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import su.psergeev77.service.post.model.Post;
import su.psergeev77.service.post.repository.PostRepository;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class PostServiceConfig {
    public static void main(String[] args) {
        SpringApplication.run(PostServiceConfig.class, args);
    }
    @Bean
    CommandLineRunner init(PostRepository repository) {

        final Post[] testPosts = {
                new Post("jhoeller", "Title 1", "Text post 1"),
                new Post("dsyer", "Title dsyer", "Text post dsyer"),
                new Post("pwebb", "Title pwebb", "Text post pwebb"),
                new Post("pwebb", "Title pwebb 2", "Text post pwebb 2"),
                new Post("ogierke", "Title ogierke", "Text post ogierke"),
                new Post("ogierke", "Title ogierke 2", "Text post ogierke 2"),
                new Post("ogierke", "Title ogierke 3", "Text post ogierke 3"),
                new Post("rwinch", "Title rwinch", "Text post rwinch")};

        return (evt) -> Arrays.asList(testPosts).forEach(a -> repository.save(a));
    }
}
