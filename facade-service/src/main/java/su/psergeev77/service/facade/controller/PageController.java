package su.psergeev77.service.facade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.psergeev77.service.facade.client.Client;
import su.psergeev77.service.facade.client.ClientRestClient;
import su.psergeev77.service.facade.model.Page;
import su.psergeev77.service.facade.model.PageNotFoundException;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/page")
public class PageController {

    @Autowired
    private ClientRestClient restClient;

    @RequestMapping(method = RequestMethod.GET, value = "/{userName}")
    public PageResource get(@PathVariable String userName) {
//        Optional<Post> post = Optional.ofNullable(repository.findOne(postId));
//        if (!post.isPresent()) {
//            throw new PostNotFoundException(postId);
//        }
//        return new PostResource(post.get());
        Client client = restClient.getClient(userName).getContent();
        if (client == null) {
            throw new PageNotFoundException(userName);
        }
        Page page = new Page(client);
        return new PageResource(page);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/client/{userName}")
//    public Resources<PostResource> getPostsForClient(@PathVariable String userName) {
//        List<PostResource> postList = repository.findAllByUserName(userName).stream()
//                .map(PostResource::new).collect(Collectors.toList());
//        return new Resources<>(postList);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    ResponseEntity<?> add(@RequestBody Post post) {
//        Post result = repository.save(post);
//        Link link = new PostResource(result).getLink("self");
//        return ResponseEntity.created(URI.create(link.getHref())).build();
//    }
}
