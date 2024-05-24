package it.epicode.gestionedispositivi.controllers.exceptions;

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

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<?> handleNotFoundException(NotFoundException ex){
        var info = new ExModel(ex.getMessage(), ex.occurredAt, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DeviceStateException.class)
    protected ResponseEntity<?> handleDeviceStateException(DeviceStateException ex){
        var info = new ExModel(ex.getMessage(), ex.occurredAt, HttpStatus.CONFLICT);
        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
