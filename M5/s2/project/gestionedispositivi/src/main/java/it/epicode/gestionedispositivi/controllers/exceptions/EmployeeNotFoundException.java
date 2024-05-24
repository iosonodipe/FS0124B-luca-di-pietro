package it.epicode.gestionedispositivi.controllers.exceptions;

import java.io.Serial;

public class EmployeeNotFoundException extends NotFoundException{
    @Serial
    private static final long serialVersionUID = 1L;

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
