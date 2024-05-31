package it.epicode.gestioneeventi.entities;

import jakarta.persistence.*;
import lombok.Data;


@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
