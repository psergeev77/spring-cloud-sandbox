package su.psergeev77.service.post.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import su.psergeev77.service.post.model.PostNotFoundException;

@ControllerAdvice
public class PostControllerAdvice {
    @ResponseBody
    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors postNotFoundException(PostNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }
}
