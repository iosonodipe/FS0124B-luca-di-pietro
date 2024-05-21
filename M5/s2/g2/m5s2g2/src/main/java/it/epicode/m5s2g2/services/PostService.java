package it.epicode.m5s2g2.services;

import it.epicode.m5s2g2.repos.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostDAO dao;

    //ritorna la lista di post
    //ritorna un singolo post
    //crea un nuovo post
    //modifica lo specifico post
    //cancella lo specifico post
}
