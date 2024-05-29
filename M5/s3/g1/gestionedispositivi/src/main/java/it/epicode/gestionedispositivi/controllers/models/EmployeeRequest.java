package it.epicode.gestionedispositivi.controllers.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EmployeeRequest(
        @NotNull(message = "Lo username deve essere specificato.")
        @Size(max = 10, message = "Lo username può essere lungo massimo 10 caratteri.")
        String username,
        @NotNull(message = "Il nome deve essere specificato.")
        String name,
        @NotNull(message = "Il cognome deve essere specificato.")
        String surname,
        @NotNull(message = "La mail deve essere specificato.")
        @Email(message = "La mail non è valida.")
        String email
) {
}
