package su.psergeev77.service.facade.post;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import su.psergeev77.service.facade.model.Page;

import java.util.Collections;
import java.util.List;

@Component
public class PostRestFallback implements PostRestClient {

    @Override
    public List<Page.Post> getPostsForClient(@PathVariable("userName") String userName) {
        return Collections.emptyList();
    }
}