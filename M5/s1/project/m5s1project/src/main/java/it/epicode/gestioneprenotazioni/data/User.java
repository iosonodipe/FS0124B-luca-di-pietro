package it.epicode.gestioneprenotazioni.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "users")
@Builder(setterPrefix = "with")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity{
    private String name;
    private String surname;
    private String email;
    private String username;
}
