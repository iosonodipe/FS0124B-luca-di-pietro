package catalogo_bibliotecario;

public class Rivista extends Catalogo {
    private Periodicita periodicity;

    public Rivista(String title, Integer publish_year, Integer pages, Periodicita periodicity) {
        super(title, publish_year, pages);
        this.periodicity = periodicity;
    }

    public Periodicita getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicita periodicity) {
        this.periodicity = periodicity;
    }
}
