package br.com.geniustest.api.exception;

import java.io.Serial;

public class EntityNotAllowedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public EntityNotAllowedException() {
        super();
    }

    public EntityNotAllowedException(String message) {
        super(message);
    }
}
