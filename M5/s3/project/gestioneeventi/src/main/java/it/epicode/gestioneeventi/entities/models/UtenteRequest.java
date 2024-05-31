package it.epicode.gestioneeventi.entities.models;

import it.epicode.gestioneeventi.entities.Ruolo;
import jakarta.validation.constraints.NotBlank;

public record UtenteRequest(
        @NotBlank(message = "Il nome non può essere vuoto")
        String nome,
        @NotBlank(message = "Il cognome non può essere vuoto")
        String cognome,
        @NotBlank(message = "Il ruolo non può essere vuoto")
        Ruolo ruolo
) {
}
