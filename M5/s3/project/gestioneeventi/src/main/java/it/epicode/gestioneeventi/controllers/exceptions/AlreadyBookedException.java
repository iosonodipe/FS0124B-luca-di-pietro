package it.epicode.gestioneeventi.controllers.exceptions;

import java.io.Serial;
import java.time.LocalDateTime;

public class AlreadyBookedException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public final LocalDateTime occurredAt;

    public AlreadyBookedException(String message) {
        super(message);
        this.occurredAt = LocalDateTime.now();
    }
}
