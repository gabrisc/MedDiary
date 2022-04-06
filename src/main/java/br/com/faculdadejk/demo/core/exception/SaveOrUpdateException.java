package br.com.faculdadejk.demo.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class SaveOrUpdateException extends RuntimeException {

    private static final long serialVersionUID = -4423267287636900702L;

    public SaveOrUpdateException(String message) {
        super(message);
    }
}
