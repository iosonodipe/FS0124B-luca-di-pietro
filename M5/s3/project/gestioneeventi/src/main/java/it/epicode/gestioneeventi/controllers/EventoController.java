package it.epicode.gestioneeventi.controllers;

import it.epicode.gestioneeventi.daos.EventoDAO;
import it.epicode.gestioneeventi.entities.Evento;
import it.epicode.gestioneeventi.entities.models.EventoRequest;
import it.epicode.gestioneeventi.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<Evento> save(@RequestBody @Validated EventoRequest body, BindingResult validator){
        if (validator.hasErrors()) throw new RuntimeException(String.valueOf(validator.getAllErrors()));
        var evento = eventoService.save(body);
        return ResponseEntity.ok(evento);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Evento> save(@PathVariable Long id, @RequestBody @Validated Evento body, BindingResult validator){
        if (validator.hasErrors()) throw new RuntimeException(String.valueOf(validator.getAllErrors()));
        var evento = eventoService.update(id, body);
        return ResponseEntity.ok(evento);
    }
}
