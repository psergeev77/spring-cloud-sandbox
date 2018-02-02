package su.psergeev77.service.facade.controller;

import org.springframework.hateoas.ResourceSupport;
import su.psergeev77.service.facade.model.Page;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PageResource extends ResourceSupport{
    private Page page;

    public PageResource(Page page) {
        String userName = page.getUserName();
        this.add(linkTo(methodOn(PageController.class, userName)
                .get(userName)).withSelfRel());
        /*this.add(linkTo(methodOn(PostController.class, userName)
                .getPostsForClient(userName)).withSelfRel());*/
    }

    public Page getPage() {
        return page;
    }
}
