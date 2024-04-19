package MediaPlayer;

public abstract class ElementoMultimediale {
    protected String titolo;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    };

    public abstract void esegui();
    //metodo necessario per avviare play() oppure show() nel Main
}
