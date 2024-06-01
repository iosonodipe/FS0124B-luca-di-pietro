package it.epicode.gestioneeventi.services;

import it.epicode.gestioneeventi.controllers.exceptions.NotFoundException;
import it.epicode.gestioneeventi.controllers.exceptions.UserNotAuthorizedException;
import it.epicode.gestioneeventi.daos.EventoDAO;
import it.epicode.gestioneeventi.daos.PrenotazioneDAO;
import it.epicode.gestioneeventi.daos.UtenteDAO;
import it.epicode.gestioneeventi.entities.Evento;
import it.epicode.gestioneeventi.entities.Utente;
import it.epicode.gestioneeventi.entities.models.EventoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventoService {
    @Autowired
    private EventoDAO eventoDAO;
    @Autowired
    private UtenteDAO utenteDAO;
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public Utente isOrganizzatore(Long id) {
        var utente = utenteDAO.findById(id).orElseThrow(() -> new NotFoundException("Utente non esistente"));
        if (utente.getRuolo().getNome().equals("organizzatore")) return utente;
        else return null;
    }

    public Evento save(EventoRequest body) {
        var utente = isOrganizzatore(body.utenteId());
        if (utente != null) {
            var evento = Evento.builder()
                   .withTitolo(body.titolo())
                   .withDescrizione(body.descrizione())
                   .withData(body.data())
                   .withLuogo(body.luogo())
                   .withNumeroPosti(body.numeroPosti())
                   .build();
            eventoDAO.save(evento);
            utente.aggiornaEventi(evento);
            utenteDAO.save(utente);
            return evento;
        } else throw new UserNotAuthorizedException("Utente non autorizzato");
    }

    public Evento update(Long idUtente, Long idEvento, Evento body){
        if (isOrganizzatore(idUtente) != null) {
            var evento = eventoDAO.findById(idEvento).orElseThrow(() -> new NotFoundException("Evento da aggiornare non trovato."));
            if (body.getTitolo() != null) evento.setTitolo(body.getTitolo());
            if (body.getDescrizione()!= null) evento.setDescrizione(body.getDescrizione());
            if (body.getData() != null) evento.setData(body.getData());
            if (body.getLuogo() != null) evento.setLuogo(body.getLuogo());
            if (body.getNumeroPosti() != 0) evento.setNumeroPosti(body.getNumeroPosti());

            return eventoDAO.save(evento);
        } else throw new UserNotAuthorizedException("Utente non autorizzato");
    }

    public Evento delete (Long idUtente, Long idEvento){
        if (isOrganizzatore(idUtente) != null) {
            var prenotazioni = prenotazioneDAO.findByEventoId(idEvento);
            var evento = eventoDAO.findById(idEvento).orElseThrow(() -> new NotFoundException("Evento da eliminare non trovato."));
            for (var prenotazione : prenotazioni) {
                prenotazioneDAO.deleteById(prenotazione.getId());
            }
            eventoDAO.deleteById(idEvento);
            return evento;
        } else throw new UserNotAuthorizedException("Utente non autorizzato");
    }
}
