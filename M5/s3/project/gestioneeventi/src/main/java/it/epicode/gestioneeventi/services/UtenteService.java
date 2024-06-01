package it.epicode.gestioneeventi.services;

import it.epicode.gestioneeventi.controllers.exceptions.AlreadyBookedException;
import it.epicode.gestioneeventi.controllers.exceptions.EventIsFullException;
import it.epicode.gestioneeventi.controllers.exceptions.NotFoundException;
import it.epicode.gestioneeventi.controllers.exceptions.UserNotAuthorizedException;
import it.epicode.gestioneeventi.daos.EventoDAO;
import it.epicode.gestioneeventi.daos.PrenotazioneDAO;
import it.epicode.gestioneeventi.daos.RuoloDAO;
import it.epicode.gestioneeventi.daos.UtenteDAO;
import it.epicode.gestioneeventi.entities.Evento;
import it.epicode.gestioneeventi.entities.Prenotazione;
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

    @Autowired
    private EventoDAO eventoDAO;

    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public Utente isOrganizzatore(Long id) {
        var utente = utenteDAO.findById(id).orElseThrow(() -> new NotFoundException("Utente non esistente"));
        if (utente.getRuolo().getNome().equals("organizzatore")) return utente;
        else return null;
    }

    public Utente save(UtenteRequest body) {
        var ruolo = ruoloDAO.findById(body.ruoloId()).orElseThrow(() -> new NotFoundException("Ruolo non trovato"));
        Utente utente = Utente.builder()
               .withNome(body.nome())
               .withCognome(body.cognome())
               .withRuolo(ruolo)
               .build();
        return utenteDAO.save(utente);
    }

    public Evento prenota(Long idUtente, Long idEvento){
        if (isOrganizzatore(idUtente) == null){
            var utente = utenteDAO.findById(idUtente).orElseThrow(() -> new NotFoundException("Utente non trovato"));
            var evento = eventoDAO.findById(idEvento).orElseThrow(() -> new NotFoundException("Evento non trovato"));
            if (evento.getNumeroPosti() == 0) throw new EventIsFullException("Non ci sono posti disponibili");
            else if (prenotazioneDAO.findByUtenteIdAndEventoId(utente.getId(), evento.getId()) != null) throw new AlreadyBookedException("Hai già effettuato la prenotazione per questo evento");
            else {
                evento.setNumeroPosti(evento.getNumeroPosti() - 1);
                eventoDAO.save(evento);
                prenotazioneDAO.save(new Prenotazione(utente, evento));
                return evento;
            }
        } else throw new UserNotAuthorizedException("Utente non autorizzato");
    }

}
