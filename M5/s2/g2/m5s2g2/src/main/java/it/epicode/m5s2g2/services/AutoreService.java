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
    public Autore create(Autore autore){
        autore.setAvatar("https://ui-avatars.com/api/?name="+ autore.getNome() + "+" + autore.getCognome());
        return dao.save(autore);
    }
    //modifica lo specifico autore
    public Autore update(Long id, Autore body) throws Exception {
        Optional<Autore> autoreCercato = dao.findById(id);
        if (autoreCercato.isPresent()){
            Autore autore = autoreCercato.get();
            if (body.getNome() != null) autore.setNome(body.getNome());
            if (body.getCognome() != null) autore.setCognome(body.getCognome());
            if (body.getEmail() != null) autore.setEmail(body.getEmail());
            if (body.getDataDiNascita() != null) autore.setDataDiNascita(body.getDataDiNascita());
            if (body.getAvatar() != null) autore.setAvatar(body.getAvatar());
            dao.save(autore);
            return autore;
        } else throw new Exception();
    }

    //cancella lo specifico autore
    public Optional<Autore> delete(Long id){
        var autore = getById(id);
        dao.deleteById(id);
        return autore;
    }
}
