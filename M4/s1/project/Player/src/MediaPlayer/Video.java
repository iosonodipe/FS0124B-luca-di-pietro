package MediaPlayer;

public class Video extends ElementoMultimediale implements Riproducibile, Luminosità{
    private int volume;
    private int durata;
    private int luminosita;
    private final int min_volume = 0;
    private final int max_volume = 10;
    private final int min_luminosita = 1;
    private final int max_luminosita = 10;


    public Video(String titolo, int volume, int durata, int luminosita) {
        super(titolo);
        this.volume = convertiPositivo(volume);
        this.durata = convertiPositivo(durata);
        this.luminosita = convertiPositivo(luminosita);
    }

    public int convertiPositivo(int valore){
        if(valore < 0) valore = -valore;
        return valore;
    }

    @Override
    public void play() {
        String livelloVolume = "";
        String livelloLuminosita = "";
        System.out.println("Riproduco...");
        for (int i = 0; i < volume; i++){
            livelloVolume += "!";
        };
        for (int i = 0; i < luminosita; i++){
            livelloLuminosita += "*";
        };
        for (int i = 0; i < durata; i++){
            System.out.println(titolo + livelloVolume + livelloLuminosita);
        };
    }

    @Override
    public void esegui() {
        play();
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

    @Override
    public void abbassaVolume() {
        if (volume != min_volume) {
            --volume;
            System.out.println("Nuovo volume: "+ volume);
        } else System.out.println("Volume minimo");
    }

    @Override
    public void alzaVolume() {
        if (volume != max_volume) {
            ++volume;
            System.out.println("Nuovo volume: "+ volume);
        } else System.out.println("Volume massimo");
    }
}
