package it.epicode.gestioneprenotazioni.services;

import it.epicode.gestioneprenotazioni.data.User;
import it.epicode.gestioneprenotazioni.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO dao;

    public void save(User user){
        dao.save(user);
    }
}
