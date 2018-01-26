package su.psergeev77.service.client.model;


public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String userName) {
        super("Could not found client: " + userName);
    }

    public ClientNotFoundException(Long userId) {
        super("Could not found clientId: " + userId);
    }
}
