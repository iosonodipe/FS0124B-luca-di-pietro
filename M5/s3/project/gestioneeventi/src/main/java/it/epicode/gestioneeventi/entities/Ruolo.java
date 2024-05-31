package it.epicode.gestioneeventi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ruoli")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ruolo extends BaseEntity {
    private String nome;
}
