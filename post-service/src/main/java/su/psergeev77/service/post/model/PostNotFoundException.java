package su.psergeev77.service.post.model;


public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String userName) {
        super("Could not found client: " + userName);
    }

    public PostNotFoundException(Long postId) {
        super("Could not found postId: " + postId);
    }
}
