package it.epicode.gestioneeventi.entities.models;

import it.epicode.gestioneeventi.entities.enums.Luoghi;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record EventoRequest(
        @NotBlank(message = "Il titolo è obbligatorio")
        String titolo,
        @NotBlank(message = "La data è obbligatoria")
        LocalDate data,
        @NotBlank(message = "Il luogo è obbligatorio")
        Luoghi luogo,
        @NotBlank(message = "Il numero di posti è obbligatorio")
        @Min(value = 1, message = "Il numero di posti deve essere maggiore o uguale a 1")
        int numeroPosti
) {
}
