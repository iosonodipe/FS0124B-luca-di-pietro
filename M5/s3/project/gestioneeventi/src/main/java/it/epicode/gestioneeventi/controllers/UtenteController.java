package it.epicode.gestioneeventi.controllers;

import it.epicode.gestioneeventi.entities.Evento;
import it.epicode.gestioneeventi.entities.Utente;
import it.epicode.gestioneeventi.entities.models.UtenteRequest;
import it.epicode.gestioneeventi.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @PostMapping
    public ResponseEntity<Utente> save(@RequestBody @Validated UtenteRequest body, BindingResult validator){
        if (validator.hasErrors()) throw new RuntimeException(String.valueOf(validator.getAllErrors()));
        var utente = utenteService.save(body);
        return ResponseEntity.ok(utente);
    }

    @PatchMapping("/prenota/{idUtente}/{idEvento}")
    public ResponseEntity<Evento> update(@PathVariable Long idUtente, @PathVariable Long idEvento){
        var prenotazione = utenteService.prenota(idUtente, idEvento);
        return ResponseEntity.ok(prenotazione);
    }


}
