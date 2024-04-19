package MediaPlayer;

public class Audio extends ElementoMultimediale implements Riproducibile{
    private int volume;
    private int durata;
    private final int min_volume = 0;
    private final int max_volume = 10;

    public Audio(String titolo, int volume, int durata){
        super(titolo);
        this.volume = convertiPositivo(volume);
        this.durata = convertiPositivo(durata);
    }

    public int convertiPositivo(int valore){ //nel caso in cui venga inserito un valore negativo, lo riassegno in positivo
        if(valore < 0) valore = -valore;
        return valore;
    }

    @Override
    public void play() { //eseguo due cicli: il primo crea la stringa relativa al volume sulla base della lunghezza del valore di volume inserito, il secondo stampa il titolo tante volte quanto il valore della durata inserita
        System.out.println("Riproduco...");
        String livelloVolume = "";
        for (int i = 0; i < volume; i++){
            livelloVolume += "!";
        };
        for (int i = 0; i < durata; i++){
            System.out.println(titolo + livelloVolume);
        };
    }

    @Override
    public void esegui() {
        play();
    }

    @Override
    public void abbassaVolume() { //se il volume è diverso dal valore del volume minimo, allora abbassa il volume, altrimenti non lo modifica
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
