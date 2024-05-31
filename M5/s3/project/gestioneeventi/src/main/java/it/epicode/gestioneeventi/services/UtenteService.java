package it.epicode.gestioneeventi.services;

import it.epicode.gestioneeventi.controllers.exceptions.RuoloNotFoundException;
import it.epicode.gestioneeventi.daos.RuoloDAO;
import it.epicode.gestioneeventi.daos.UtenteDAO;
import it.epicode.gestioneeventi.entities.Utente;
import it.epicode.gestioneeventi.entities.models.UtenteRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {
    @Autowired
    private UtenteDAO utenteDAO;

    @Autowired
    private RuoloDAO ruoloDAO;

    public Utente save(UtenteRequest body) {
        var ruolo = ruoloDAO.findById(body.ruoloId()).orElseThrow(() -> new RuoloNotFoundException("Ruolo non trovato"));
        Utente utente = Utente.builder()
               .withNome(body.nome())
               .withCognome(body.cognome())
               .withRuolo(ruolo)
               .build();
        return utenteDAO.save(utente);
    }

}
