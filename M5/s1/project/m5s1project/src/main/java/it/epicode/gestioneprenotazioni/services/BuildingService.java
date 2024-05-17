package it.epicode.gestioneprenotazioni.services;

import it.epicode.gestioneprenotazioni.data.Building;
import it.epicode.gestioneprenotazioni.repos.BuildingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    @Autowired
    BuildingDAO dao;

    public void save(Building building){
        dao.save(building);
    }
}
