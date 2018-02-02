package su.psergeev77.service.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import su.psergeev77.service.post.model.Post;
import su.psergeev77.service.post.model.PostNotFoundException;
import su.psergeev77.service.post.repository.PostRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostRepository repository;

    @RequestMapping(method = RequestMethod.GET, value = "/{postId}")
    public Post get(@PathVariable Long postId) {
        Optional<Post> post = Optional.ofNullable(repository.findOne(postId));
        if (!post.isPresent()) {
            throw new PostNotFoundException(postId);
        }
        return post.get();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/client/{userName}")
    public List<Post> getPostsForClient(@PathVariable String userName) {
        return repository.findAllByUserName(userName);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Post post) {
        Post result = repository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/post/{postId}")
                .buildAndExpand(result.getUserName()).toUri();
        return ResponseEntity.created(location).build();
    }
}
