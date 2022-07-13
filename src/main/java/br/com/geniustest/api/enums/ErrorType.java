package br.com.geniustest.api.enums;

import lombok.Getter;

@Getter
public enum ErrorType {

    FORBIDDEN("Access denied, no privilege");

    private final String title;

    ErrorType(String title) {
        this.title = title;
    }

}
