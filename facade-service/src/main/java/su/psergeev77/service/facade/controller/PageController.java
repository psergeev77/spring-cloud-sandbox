package su.psergeev77.service.facade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import su.psergeev77.service.facade.client.Client;
import su.psergeev77.service.facade.client.ClientRestClient;
import su.psergeev77.service.facade.model.Page;
import su.psergeev77.service.facade.model.PageNotFoundException;
import su.psergeev77.service.facade.post.PostRestClient;

import java.util.List;


@RestController
@RequestMapping("/page")
public class PageController {

    @Autowired
    private ClientRestClient clientRestClient;

    @Autowired
    private PostRestClient postRestClient;

    @RequestMapping(method = RequestMethod.GET, value = "/{userName}")
    public Page get(@PathVariable String userName) {
        Client client = clientRestClient.getClient(userName);
        if (client == null) {
            throw new PageNotFoundException(userName);
        }
        Page page = new Page(client);

        List<Page.Post> postList = postRestClient.getPostsForClient(userName);
        page.setPosts(postList);

        return page;
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
