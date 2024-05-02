import data.TipoEvento;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import services.EventoDAO;

import java.time.LocalDate;

public class Main {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    static EventoDAO svc = new EventoDAO(emf.createEntityManager());
    static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        svc.save("Formaggi atomici", LocalDate.now(), "Evento magnifico di formaggi caserecci", TipoEvento.PRIVATO, 50);
        svc.save("Salami piccanti", LocalDate.now(), "Convention dei salami nostrani", TipoEvento.PRIVATO, 20);
        svc.save("Torte della nonna", LocalDate.now(), "La sagra delle torte ", TipoEvento.PUBBLICO, 100);
//        svc.getById(202);
//        svc.remove(202);
    }
}