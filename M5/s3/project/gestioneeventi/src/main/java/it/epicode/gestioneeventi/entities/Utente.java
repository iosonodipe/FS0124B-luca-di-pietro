package it.epicode.gestioneeventi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "eventi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente extends BaseEntity {
    private String nome;
    private String cognome;
    @OneToMany(mappedBy = "utente", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Evento> eventi;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ruolo_id")
    private Ruolo ruolo;

    @Builder(setterPrefix = "with")
    public Utente(String nome, String cognome, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
    }
}
