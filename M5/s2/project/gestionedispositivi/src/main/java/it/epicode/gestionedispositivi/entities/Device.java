package it.epicode.gestionedispositivi.entities;

import it.epicode.gestionedispositivi.entities.enums.DeviceState;
import it.epicode.gestionedispositivi.entities.enums.DeviceType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "devices")
@Data
@NoArgsConstructor
public class Device extends Base{
    private DeviceType type;
    private DeviceState state;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Builder(setterPrefix = "with")
    public Device(DeviceType type, DeviceState state) {
        this.type = type;
        this.state = state;
    }
}
