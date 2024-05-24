package it.epicode.gestionedispositivi.entities;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName = "id_generator")
    private Long id;
}
