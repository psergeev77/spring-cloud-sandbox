package su.psergeev77.service.facade.model;


public class PageNotFoundException extends RuntimeException {

    public PageNotFoundException(String userName) {
        super("Could not found page: " + userName);
    }

}
