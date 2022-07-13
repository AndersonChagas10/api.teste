package br.com.geniustest.api.exception;

import br.com.geniustest.api.enums.ErrorType;
import br.com.geniustest.api.generic.GenericObjectError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (body == null) {
            body = GenericObjectError.builder().title(status.getReasonPhrase()).statusCode(status.value()).build();
        } else if (body instanceof String) {
            body = GenericObjectError.builder().title((String) body).build();
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        ErrorType errorType = ErrorType.FORBIDDEN;
        String detail = ex.getMessage();
        GenericObjectError error = creatErroBuilder(status, errorType, detail).userMessage(detail).build();
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    private GenericObjectError.GenericObjectErrorBuilder creatErroBuilder(HttpStatus status, ErrorType errorType, String detail) {
        return GenericObjectError.builder().statusCode(status.value()).title(errorType.getTitle()).detail(detail)
                .dataHora(OffsetDateTime.now());
    }



}
