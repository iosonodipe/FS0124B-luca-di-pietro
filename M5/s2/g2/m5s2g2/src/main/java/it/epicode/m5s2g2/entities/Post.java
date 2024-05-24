package it.epicode.m5s2g2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    @ManyToOne
    @JoinColumn(name = "id_autore")
    private Autore autore;

}
