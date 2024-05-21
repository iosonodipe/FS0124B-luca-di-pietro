package it.epicode.m5s2g2.repos;

import it.epicode.m5s2g2.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO extends JpaRepository<Post, Long> {
}
