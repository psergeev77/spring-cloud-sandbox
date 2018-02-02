package su.psergeev77.service.client.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String userName) {
        super("Could not found client: " + userName);
    }

    public ClientNotFoundException(Long userId) {
        super("Could not found clientId: " + userId);
    }
}
