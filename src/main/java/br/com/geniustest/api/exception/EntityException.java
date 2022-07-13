package br.com.geniustest.api.exception;

import java.io.Serial;

public class EntityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public EntityException() {
        super();
    }

    public EntityException(String message) {
        super(message);
    }
}
