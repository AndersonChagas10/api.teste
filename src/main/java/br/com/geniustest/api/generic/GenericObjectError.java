package br.com.geniustest.api.generic;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Builder
public class GenericObjectError {

    private Integer statusCode;
    private String title;
    private String detail;
    private String userMessage;
    private OffsetDateTime dataHora;
    private List<Object> objects;

    @Builder
    @Getter
    public static class Object {
        private String name;
        private String userMessage;
    }

}
