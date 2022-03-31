package br.com.faculdadejk.demo.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8486790922817422765L;

    public NotFoundException(String exception) {
        super(exception);
    }
}
