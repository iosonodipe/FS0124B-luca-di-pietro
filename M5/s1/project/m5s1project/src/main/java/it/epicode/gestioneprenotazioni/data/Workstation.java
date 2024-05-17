package it.epicode.gestioneprenotazioni.data;

import it.epicode.gestioneprenotazioni.data.enums.WorkstationType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workstations")
@Data
@EqualsAndHashCode(callSuper = true)
public class Workstation extends BaseEntity {
    private String description;
    private WorkstationType type;
    private int capacity;
    @OneToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @Builder(setterPrefix = "with")
    public Workstation(String description, WorkstationType type, int capacity, Building building) {
        this.description = description;
        this.type = type;
        this.capacity = capacity;
        this.building = building;
    }

    public Workstation(){}
}
