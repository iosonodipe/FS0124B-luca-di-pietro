package it.epicode.gestioneprenotazioni.data;

import it.epicode.gestioneprenotazioni.data.enums.WorkstationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean("user_luca")
    public User userLucaBean(){
        return User.builder()
                .withName("Luca")
                .withSurname("Di Pietro")
                .withEmail("luca@mail.it")
                .withUsername("lucaepicode")
                .build();
    }

    @Bean("user_mario")
    public User userMarioBean(){
        return User.builder()
                .withName("Mario")
                .withSurname("Varano")
                .withEmail("mario@mail.it")
                .withUsername("marioepicode")
                .build();
    }

    @Bean("user_luigi")
    public User userLuigiBean(){
        return User.builder()
                .withName("Luigi")
                .withSurname("Guajana")
                .withEmail("luigi@mail.it")
                .withUsername("luigiepicode")
                .build();
    }

    @Bean("building1")
    public Building building1Bean(){
        return Building.builder()
                .withName("building1")
                .withAddress("via Biraghi 1")
                .withCity("milano")
                .build();
    }

    @Bean("building2")
    public Building building2Bean(){
        return Building.builder()
                .withName("building2")
                .withAddress("via Carroccio 30")
                .withCity("milano")
                .build();
    }

    @Bean("workstation1")
    public Workstation workstation1Bean(){
        return Workstation.builder()
                .withBuilding(building1Bean())
                .withCapacity(1)
                .withDescription("Bellissima postazione in edificio 1")
                .withType(WorkstationType.PRIVATE)
                .build();
    }

    @Bean("workstation2")
    public Workstation workstation2Bean(){
        return Workstation.builder()
                .withBuilding(building2Bean())
                .withCapacity(2)
                .withDescription("Bellissima postazione in edificio 2")
                .withType(WorkstationType.OPENSPACE)
                .build();
    }
}
