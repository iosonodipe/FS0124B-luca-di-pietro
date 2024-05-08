package app;

import app.data.TipoEvento;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import app.services.EventoDAO;

import java.time.LocalDate;

public class Main {
    static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
         final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EventoDAO svc = new EventoDAO(emf.createEntityManager());
        logger.error("errore");
        svc.save("Formaggi atomici", LocalDate.now(), "Evento magnifico di formaggi caserecci", TipoEvento.PRIVATO, 50);
        svc.save("Salami piccanti", LocalDate.now(), "Convention dei salami nostrani", TipoEvento.PRIVATO, 20);
        svc.save("Torte della nonna", LocalDate.now(), "La sagra delle torte ", TipoEvento.PUBBLICO, 100);
//        svc.getById(202);
//        svc.remove(202);
    }
}