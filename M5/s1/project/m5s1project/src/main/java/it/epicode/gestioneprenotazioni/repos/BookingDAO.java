package it.epicode.gestioneprenotazioni.repos;

import it.epicode.gestioneprenotazioni.data.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Long> {

    List<Booking> findByDateAndWorkstationId(LocalDate date, Long workstationId);
}
