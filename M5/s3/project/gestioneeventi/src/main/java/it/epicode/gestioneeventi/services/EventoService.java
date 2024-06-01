package it.epicode.gestioneeventi.services;

import it.epicode.gestioneeventi.controllers.exceptions.NotFoundException;
import it.epicode.gestioneeventi.controllers.exceptions.UserNotAuthorizedException;
import it.epicode.gestioneeventi.daos.EventoDAO;
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

    public Evento update(Long id, Evento body){
        var evento = eventoDAO.findById(id).orElseThrow(() -> new NotFoundException("Evento da aggiornare non trovato."));
            if (body.getTitolo() != null) evento.setTitolo(body.getTitolo());
            if (body.getDescrizione()!= null) evento.setDescrizione(body.getDescrizione());
            if (body.getData() != null) evento.setData(body.getData());
            if (body.getLuogo() != null) evento.setLuogo(body.getLuogo());
            if (body.getNumeroPosti() != 0) evento.setNumeroPosti(body.getNumeroPosti());

        return eventoDAO.save(evento);
    }

    public Evento delete (Long id){
        //ricordarsi di fare il controllo se l'utente è l'organizzatore
        var evento = eventoDAO.findById(id).orElseThrow(() -> new NotFoundException("Evento da eliminare non trovato."));
            eventoDAO.deleteById(id);
        return evento;
    }
}
