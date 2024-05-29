package it.epicode.gestionedispositivi.controllers.exceptions;

import java.io.Serial;
import java.time.LocalDateTime;

public class NotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public final LocalDateTime occurredAt;

    public NotFoundException(String message) {
        super(message);
        occurredAt = LocalDateTime.now();
    }
}
