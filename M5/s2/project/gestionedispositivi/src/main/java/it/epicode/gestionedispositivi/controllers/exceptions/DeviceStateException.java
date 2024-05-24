package it.epicode.gestionedispositivi.controllers.exceptions;

import java.io.Serial;
import java.time.LocalDateTime;

public class DeviceStateException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public final LocalDateTime occurredAt;

    public DeviceStateException(String message) {
        super(message);
        occurredAt = LocalDateTime.now();
    }
}
