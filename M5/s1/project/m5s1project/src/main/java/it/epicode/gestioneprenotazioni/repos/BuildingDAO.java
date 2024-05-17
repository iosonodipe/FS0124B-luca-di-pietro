package it.epicode.gestioneprenotazioni.repos;

import it.epicode.gestioneprenotazioni.data.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingDAO extends JpaRepository<Building, Long> {
}
