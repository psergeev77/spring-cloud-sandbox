package su.psergeev77.service.facade.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import su.psergeev77.service.facade.model.PageNotFoundException;

@ControllerAdvice
public class PageControllerAdvice {
    @ResponseBody
    @ExceptionHandler(PageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors pageNotFoundException(PageNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }
}
