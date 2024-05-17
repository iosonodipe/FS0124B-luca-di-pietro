package it.epicode.gestioneprenotazioni;

import it.epicode.gestioneprenotazioni.data.AppConfig;
import it.epicode.gestioneprenotazioni.data.User;
import it.epicode.gestioneprenotazioni.data.enums.WorkstationType;
import it.epicode.gestioneprenotazioni.services.BookingService;
import it.epicode.gestioneprenotazioni.services.BuildingService;
import it.epicode.gestioneprenotazioni.services.UserService;
import it.epicode.gestioneprenotazioni.services.WorkstationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@Slf4j
public class Runner implements CommandLineRunner{

    @Autowired
    BookingService bookingService;

    @Autowired
    BuildingService buildingService;

    @Autowired
    UserService userService;

    @Autowired
    WorkstationService workstationService;

    @Autowired
    AppConfig config;

    @Override
    public void run(String... args) throws Exception {
        try{
            var userMario = config.userMarioBean();
            var userLuca = config.userLucaBean();
            var userLuigi = config.userLuigiBean();
            var workstation1 = config.workstation1Bean();
            var workstation2 = config.workstation2Bean();
            userService.save(userMario);
            userService.save(userLuca);
            userService.save(userLuigi);
            buildingService.save(config.building1Bean());
            buildingService.save(config.building2Bean());
            workstationService.save(workstation1);
            workstationService.save(workstation2);

//            bookingService.createBooking(LocalDate.now(), userMario, 1L);
            bookingService.createBooking(LocalDate.now(), userLuca, 2L);
            bookingService.createBooking(LocalDate.now(), userMario, 2L);
            bookingService.createBooking(LocalDate.now(), userLuigi, 2L);

            workstationService.searchWorkstationByTypeAndCity(WorkstationType.PRIVATE, "Milano");

        } catch (Exception ex){
            log.error(String.valueOf(ex));
        }
    }
}
