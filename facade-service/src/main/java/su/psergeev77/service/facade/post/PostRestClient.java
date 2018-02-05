package su.psergeev77.service.facade.post;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import su.psergeev77.service.facade.model.Page;

import java.util.List;

@FeignClient(name="post-service", path = "/post")
public interface PostRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "/client/{userName}")
    List<Page.Post> getPostsForClient(@PathVariable("userName") String userName);
}
