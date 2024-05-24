package it.epicode.gestionedispositivi.controllers.exceptions;

import java.io.Serial;

public class DeviceDisusedException extends DeviceStateException{
    @Serial
    private static final long serialVersionUID = 1L;

    public DeviceDisusedException(String message) {
        super(message);
    }
}
