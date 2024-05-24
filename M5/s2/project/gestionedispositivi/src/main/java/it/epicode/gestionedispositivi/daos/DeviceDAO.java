package it.epicode.gestionedispositivi.daos;

import it.epicode.gestionedispositivi.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDAO extends JpaRepository<Device, Long> {
}
