package it.epicode.gestioneeventi.daos;

import it.epicode.gestioneeventi.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoDAO extends JpaRepository<Evento, Long> {
}
