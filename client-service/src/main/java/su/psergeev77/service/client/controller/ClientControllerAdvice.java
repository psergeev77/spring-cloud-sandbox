package su.psergeev77.service.client.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import su.psergeev77.service.client.model.ClientNotFoundException;

@ControllerAdvice
public class ClientControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors clientNotFoundException(ClientNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }
}
