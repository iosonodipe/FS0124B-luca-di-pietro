package it.epicode.gestionedispositivi.controllers.exceptions;

import java.io.Serial;

public class DeviceUnderMaintenanceException extends DeviceStateException{
    @Serial
    private static final long serialVersionUID = 1L;

    public DeviceUnderMaintenanceException(String message) {
        super(message);
    }
}
