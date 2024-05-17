package it.epicode.gestioneprenotazioni.services;

import it.epicode.gestioneprenotazioni.data.Booking;
import it.epicode.gestioneprenotazioni.data.User;
import it.epicode.gestioneprenotazioni.data.Workstation;
import it.epicode.gestioneprenotazioni.repos.BookingDAO;
import it.epicode.gestioneprenotazioni.repos.WorkstationDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class BookingService {
    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    WorkstationDAO workstationDAO;

    public void save(Booking booking){
        bookingDAO.save(booking);
    }

    public void createBooking(LocalDate date, User user, Long workstationId){
        Workstation ws = workstationDAO.findById(workstationId).orElse(null);
        if (ws == null) {
            log.warn("La postazione non esiste.");
        }
        else if (ws.getCapacity() - bookingDAO.findByDateAndWorkstationId(date, ws.getId()).size() == 0) {
            log.warn("Non è possibile prenotare poichè la postazione ha raggiunto la massima capienza.");
        } else if(bookingDAO.findByDateAndUserId(date, user.getId()) != null){
            log.warn("Non puoi effettuare due prenotazioni nello stesso giorno.");
        } else {
            log.info("Prenotazione effettuata!");
            save(new Booking(date, user, ws));
        }
    }
}
