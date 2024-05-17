package it.epicode.gestioneprenotazioni.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "buildings")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Building extends BaseEntity{
    private String name;
    private String address;
    private String city;
}
