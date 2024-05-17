package it.epicode.gestioneprenotazioni.data;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
@EqualsAndHashCode(callSuper = true)
public class Booking extends BaseEntity{
    private LocalDate date;
    private LocalDate validita;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "workstation_id")
    private Workstation workstation;

    @Builder(setterPrefix = "with")
    public Booking(LocalDate date, User user, Workstation workstation) {
        this.date = date;
        this.validita = date.plusDays(1);
        this.user = user;
        this.workstation = workstation;
    }

    public Booking(){}
}
