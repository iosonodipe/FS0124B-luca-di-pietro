package it.epicode.m5s2g2.controller;

import it.epicode.m5s2g2.entities.Autore;
import it.epicode.m5s2g2.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    AutoreService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public void create(@RequestBody Autore body) throws Exception {
        service.create(body);
    }

    @GetMapping
    public List<Autore> getAll(){ return service.getAll();}

    @GetMapping("/{idAutore}")
    public Optional<Autore> getById(@PathVariable Long idAutore) throws Exception {
        return service.getById(idAutore);
    }

    @PutMapping("/{idAutore}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void findAndUpdateById(@PathVariable Long idAutore, @RequestBody Autore body) throws Exception{
        service.findAndUpdateById(idAutore, body);
    }
}
