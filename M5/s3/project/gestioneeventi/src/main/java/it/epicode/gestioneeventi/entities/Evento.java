package it.epicode.gestioneeventi.entities;

import it.epicode.gestioneeventi.entities.enums.Luoghi;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "eventi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Evento extends BaseEntity {
    private String titolo;
    private String descrizione;
    private LocalDate data;
    private Luoghi luogo;
    private int numeroPosti;
}
