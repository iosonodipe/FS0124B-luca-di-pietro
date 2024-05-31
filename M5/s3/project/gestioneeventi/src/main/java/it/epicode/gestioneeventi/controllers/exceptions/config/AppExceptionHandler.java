package it.epicode.gestioneeventi.controllers.exceptions.config;

import it.epicode.gestioneeventi.controllers.exceptions.EventIsFullException;
import it.epicode.gestioneeventi.controllers.exceptions.RuoloNotFoundException;
import it.epicode.gestioneeventi.controllers.exceptions.UserNotAuthorizedException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Controller
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @Data
    @AllArgsConstructor
    public static class ExModel{
        private String message;
        private LocalDateTime occurredAt;
        private HttpStatus status;
    }

    @ExceptionHandler(EventIsFullException.class)
    protected ResponseEntity<?> handleEventIsFullException(EventIsFullException ex){
        var info = new ExModel(ex.getMessage(), ex.occurredAt, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotAuthorizedException.class)
    protected ResponseEntity<?> handelUserNotAuthorizedException(UserNotAuthorizedException ex){
        var info = new ExModel(ex.getMessage(), ex.occurredAt, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuoloNotFoundException.class)
    protected ResponseEntity<?> handleRuoloNotFoundException(RuoloNotFoundException ex){
        var info = new ExModel(ex.getMessage(), ex.occurredAt, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
