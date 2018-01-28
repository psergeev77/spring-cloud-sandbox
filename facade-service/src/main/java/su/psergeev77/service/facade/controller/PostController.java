package su.psergeev77.service.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.psergeev77.service.post.model.Post;
import su.psergeev77.service.post.model.PostNotFoundException;
import su.psergeev77.service.post.repository.PostRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostRepository repository;

    @RequestMapping(method = RequestMethod.GET, value = "/{postId}")
    public PostResource get(@PathVariable Long postId) {
        Optional<Post> post = Optional.ofNullable(repository.findOne(postId));
        if (!post.isPresent()) {
            throw new PostNotFoundException(postId);
        }
        return new PostResource(post.get());

    }

    @RequestMapping(method = RequestMethod.GET, value = "/client/{userName}")
    public Resources<PostResource> getPostsForClient(@PathVariable String userName) {
        List<PostResource> postList = repository.findAllByUserName(userName).stream()
                .map(PostResource::new).collect(Collectors.toList());
        return new Resources<>(postList);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Post post) {
        Post result = repository.save(post);
        Link link = new PostResource(result).getLink("self");
        return ResponseEntity.created(URI.create(link.getHref())).build();
    }
}
