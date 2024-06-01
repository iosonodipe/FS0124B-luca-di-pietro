package it.epicode.gestioneeventi.daos;

import it.epicode.gestioneeventi.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Long> {
    Prenotazione findByUtenteIdAndEventoId(Long idUtente, Long idEvento);
    List<Prenotazione> findByEventoId(Long idEvento);
}
