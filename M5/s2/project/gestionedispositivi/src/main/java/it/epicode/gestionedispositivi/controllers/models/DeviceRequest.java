package it.epicode.gestionedispositivi.controllers.models;

import it.epicode.gestionedispositivi.entities.Employee;
import it.epicode.gestionedispositivi.entities.enums.DeviceState;
import it.epicode.gestionedispositivi.entities.enums.DeviceType;
import jakarta.validation.constraints.NotNull;

public record DeviceRequest(
        @NotNull(message = "Il tipo di device deve essere specificato.")
        DeviceType type,
        @NotNull(message = "Lo stato del device deve essere specificato.")
        DeviceState state,
        Employee employee
) {
}
