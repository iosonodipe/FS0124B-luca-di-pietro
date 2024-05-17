package it.epicode.gestioneprenotazioni.services;

import it.epicode.gestioneprenotazioni.data.Workstation;
import it.epicode.gestioneprenotazioni.data.enums.WorkstationType;
import it.epicode.gestioneprenotazioni.repos.WorkstationDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkstationService {
    @Autowired
    WorkstationDAO dao;

    public void save(Workstation workstation){
        dao.save(workstation);
    }

    public void searchWorkstationByTypeAndCity(WorkstationType type, String city){
        var result = dao.findByTypeAndBuildingCity(WorkstationType.PRIVATE, city.toLowerCase());
        if (result.size() != 0){
        for(Workstation element: result){
            log.info(element.toString());
        }
        } else log.warn("Nessun risultato trovato.");
    }
}
