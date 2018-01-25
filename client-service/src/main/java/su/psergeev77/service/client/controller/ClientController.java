package su.psergeev77.service.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import su.psergeev77.service.client.model.Client;
import su.psergeev77.service.client.model.ClientNotFoundException;
import su.psergeev77.service.client.repository.ClientRepository;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository repository;

    @RequestMapping(method = RequestMethod.GET, value = "/{userName}")
    public ClientResource get(@PathVariable String userName) {
        Optional<Client> client = repository.findByUserName(userName);
        if (!client.isPresent()) {
            throw new ClientNotFoundException(userName);
        }
        return new ClientResource(client.get());

    }

    /*@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public Client get(@PathVariable Long userId) {
        Optional<Client> client = Optional.of(repository.findOne(userId));
        if (!client.isPresent()) {
            throw new ClientNotFoundException(userId);
        }
        return client.get();

    }*/

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Client client) {
        Client result = repository.save(client);
        Link link = new ClientResource(result).getLink("self");
        return ResponseEntity.created(URI.create(link.getHref())).build();
    }
}
