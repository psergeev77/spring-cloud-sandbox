package su.psergeev77.service.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public Client get(@PathVariable String userName) {
        Optional<Client> client = repository.findByUserName(userName);
        if (!client.isPresent()) {
            throw new ClientNotFoundException(userName);
        }
        return client.get();

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
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/client/{userName}")
                .buildAndExpand(result.getUserName()).toUri();
        return ResponseEntity.created(location).build();
    }
}
