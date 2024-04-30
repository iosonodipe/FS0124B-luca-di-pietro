package services;

import data.Evento;
import data.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Date;

public class EventoDAO {
    // crea un factory per l'entity manager
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    // tramite il factory crea l'entity manager
    private EntityManager em = emf.createEntityManager();
    // apre una transazione
    private EntityTransaction trans = em.getTransaction();
    private final Logger logger = LoggerFactory.getLogger(EventoDAO.class);

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
