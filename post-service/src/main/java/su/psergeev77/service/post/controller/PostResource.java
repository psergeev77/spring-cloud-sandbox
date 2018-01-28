package su.psergeev77.service.post.controller;

import org.springframework.hateoas.ResourceSupport;
import su.psergeev77.service.post.model.Post;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PostResource extends ResourceSupport{
    private Post post;

    public PostResource(Post post) {
        Long postId = post.getId();
        String userName = post.getUserName();
        this.post = post;
        this.add(linkTo(methodOn(PostController.class, postId)
                .get(postId)).withSelfRel());
        /*this.add(linkTo(methodOn(PostController.class, userName)
                .getPostsForClient(userName)).withSelfRel());*/
    }

    public Post getPost() {
        return post;
    }
}
