package MediaPlayer;

import java.util.Scanner;

public class Player {
    private ElementoMultimediale[] array = new ElementoMultimediale[5];

    public void exec(){
        System.out.print("Seleziona un elemento multimediale da creare tra 1-Audio, 2-Immagine o 3-Video: ");
        Scanner scanner = new Scanner(System.in);
        int elemento = scanner.nextInt();
        switch (elemento){
            case 1:
                scanner.reset();
                System.out.print("Inserisci il titolo della traccia Audio: ");
                String titolo = scanner.nextLine();
        }
    }
}
