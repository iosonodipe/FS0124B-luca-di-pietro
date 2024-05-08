package app.data;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;;

    private String nome;
    private String cognome;
    private String email;
    private LocalDate nascita;
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> listaPartecipazioni = new ArrayList<>();

    public Persona() {
    }

    public Persona(String nome, String cognome, String email, LocalDate nascita, Sesso sesso, List<Partecipazione> listaPartecipazioni) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.nascita = nascita;
        this.sesso = sesso;
        this.listaPartecipazioni = listaPartecipazioni;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public void setNascita(LocalDate nascita) {
        this.nascita = nascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Persona >> " +
                "id = " + id +
                ", nome = " + nome +
                ", cognome = " + cognome +
                ", email = " + email +
                ", nascita = " + nascita +
                ", sesso = " + sesso +
                ", listaPartecipazioni = " + listaPartecipazioni +
                " <<";
    }
}
