package it.epicode.gestioneeventi.entities.models;

import it.epicode.gestioneeventi.entities.enums.Luoghi;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EventoRequest(
        @NotBlank(message = "Il titolo è obbligatorio")
        String titolo,
        String descrizione,
        @NotNull(message = "La data è obbligatoria")
        LocalDate data,
        @NotNull(message = "Il luogo è obbligatorio")
        Luoghi luogo,
        @NotNull(message = "Il numero di posti è obbligatorio")
        @Min(value = 1, message = "Il numero di posti deve essere maggiore o uguale a 1")
        Integer numeroPosti,
        @NotNull(message = "ID utente è obbligatorio")
        Long utenteId
) {
}
