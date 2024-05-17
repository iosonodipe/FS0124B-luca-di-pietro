package it.epicode.gestioneprenotazioni.repos;

import it.epicode.gestioneprenotazioni.data.Workstation;
import it.epicode.gestioneprenotazioni.data.enums.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkstationDAO extends JpaRepository<Workstation, Long> {

    List<Workstation> findByTypeAndBuildingCity(WorkstationType type, String city);

}
