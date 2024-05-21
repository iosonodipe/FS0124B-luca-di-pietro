package it.epicode.m5s2g2.services;

import it.epicode.m5s2g2.entities.Autore;
import it.epicode.m5s2g2.repos.AutoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoreService {
    @Autowired
    AutoreDAO dao;

    //ritorna la lista autori
    public List<Autore> getAll(){
        return dao.findAll();
    }
    //ritorna un singolo autore
    public Optional<Autore> getById(Long id){
        return dao.findById(id);
    }
    //crea un nuovo autore
    public void create(Autore autore){
        autore.setAvatar("https://ui-avatars.com/api/?name="+ autore.getNome() + "+" + autore.getCognome());
        dao.save(autore);
    }
    //modifica lo specifico autore
    public void findAndUpdateById(Long id, Autore body) throws Exception {
        Optional<Autore> autoreCercato = dao.findById(id);
        if (autoreCercato.isPresent()){
            Autore autore = autoreCercato.get();
            autore.setNome(body.getNome());
            autore.setCognome(body.getCognome());
            autore.setEmail(body.getEmail());
            autore.setDataDiNascita(body.getDataDiNascita());
            autore.setAvatar(body.getAvatar());
            dao.save(autore);
        } else throw new Exception();
    }

    //cancella lo specifico autore
}
