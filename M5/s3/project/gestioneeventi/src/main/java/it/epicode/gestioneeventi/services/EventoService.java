package it.epicode.gestioneeventi.services;

import it.epicode.gestioneeventi.daos.EventoDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventoService {
    @Autowired
    private EventoDAO eventoDAO;
}
