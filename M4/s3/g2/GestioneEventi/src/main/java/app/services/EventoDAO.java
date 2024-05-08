package app.services;

import app.data.Evento;
import app.data.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class EventoDAO {
    private static final Logger log = LoggerFactory.getLogger(EventoDAO.class);
    private EntityManager em;
    // apre una transazione
    private EntityTransaction trans ;
    private final Logger logger = LoggerFactory.getLogger(EventoDAO.class);

    public EventoDAO(EntityManager em){
        log.debug("Constructor");
        this.em = em;
        trans = em.getTransaction();
    }

    public void save(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti){
        trans.begin();
        em.merge(new Evento(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti));
        trans.commit();
    }

    public Evento getById(long id){
        var evento = em.find(Evento.class, id);
        logger.info(evento.toString());
        return evento;
    }

    public void remove(long id){
        var evento = em.find(Evento.class, id);
        trans.begin();
        em.remove(evento);
        trans.commit();
        logger.info(evento.getTitolo() + " rimosso");
    }

}
