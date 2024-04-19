package MediaPlayer;

public class Immagine extends ElementoMultimediale implements Luminosità{
    private int luminosita;
    private final int min_luminosita = 1;
    private final int max_luminosita = 10;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    @Override
    public void esegui() {
        show();
    }

    private void show() {
        String livelloLuminosita = "";
        System.out.println("Mostro...");
        for (int i = 0; i < luminosita; i++){
            livelloLuminosita += "*";
        };
        System.out.println(titolo + livelloLuminosita);
    }

    @Override
    public void aumentaLuminosita() {
        if (luminosita != max_luminosita) {
            ++luminosita;
            System.out.println("Nuova luminosità: "+ luminosita);
        } else System.out.println("Luminosità massima");
    }

    @Override
    public void diminuisciLuminosita() {
        if (luminosita != min_luminosita) {
            --luminosita;
            System.out.println("Nuova luminosità: "+ luminosita);
        } else System.out.println("Luminosità minima");
    }
}
