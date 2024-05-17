package it.epicode.gestioneprenotazioni.repos;

import it.epicode.gestioneprenotazioni.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
