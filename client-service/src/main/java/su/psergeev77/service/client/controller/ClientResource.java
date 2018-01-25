package su.psergeev77.service.client.controller;

import org.springframework.hateoas.ResourceSupport;
import su.psergeev77.service.client.model.Client;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Pavel_Redin on 1/25/2018.
 */
public class ClientResource extends ResourceSupport{
    private Client client;

    public ClientResource(Client client) {
        String userName = client.getUserName();
        this.client = client;
        this.add(linkTo(methodOn(ClientController.class, userName)
                .get(userName)).withSelfRel());
    }

    public Client getClient() {
        return client;
    }
}
