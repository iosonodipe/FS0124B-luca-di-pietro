package it.epicode.gestionedispositivi.controllers.exceptions;

import java.io.Serial;
import java.time.LocalDateTime;

public class DeviceAlreadyAssignedException extends DeviceStateException{
    @Serial
    private static final long serialVersionUID = 1L;

    public DeviceAlreadyAssignedException(String message) {
        super(message);
    }
}
