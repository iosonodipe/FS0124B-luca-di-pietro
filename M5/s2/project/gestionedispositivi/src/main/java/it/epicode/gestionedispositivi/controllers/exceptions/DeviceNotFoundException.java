package it.epicode.gestionedispositivi.controllers.exceptions;

import java.io.Serial;

public class DeviceNotFoundException extends NotFoundException {
    @Serial
    private static final long serialVersionUID = 1L;


    public DeviceNotFoundException(String message) {
        super(message);
    }
}
