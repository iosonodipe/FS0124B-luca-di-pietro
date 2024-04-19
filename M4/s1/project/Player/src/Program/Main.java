package Program;

import MediaPlayer.Audio;
import MediaPlayer.Immagine;
import MediaPlayer.Video;

public class Main {
    public static void main(String[] args) {
        Immagine img = new Immagine("suca", 5);
        img.esegui();
        img.aumentaLuminosita();
        img.esegui();
    }
}