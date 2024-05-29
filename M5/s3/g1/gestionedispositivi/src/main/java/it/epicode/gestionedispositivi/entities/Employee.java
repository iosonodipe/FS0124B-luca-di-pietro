package it.epicode.gestionedispositivi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Employee extends Base {
    private String username;
    private String name;
    private String surname;
    private String email;
}
