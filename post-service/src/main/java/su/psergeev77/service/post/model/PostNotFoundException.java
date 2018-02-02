package su.psergeev77.service.post.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String userName) {
        super("Could not found client: " + userName);
    }

    public PostNotFoundException(Long postId) {
        super("Could not found postId: " + postId);
    }
}
