
package data;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("rivista")
public class Riviste extends Catalogo {
    private Periodicita periodicita;

    public Riviste(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
        super(titolo, annoPubblicazione, numeroPagine);
    }

    public Riviste() {
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita=" + periodicita +
                '}';
    }
}
