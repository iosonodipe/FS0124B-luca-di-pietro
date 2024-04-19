package MediaPlayer;

import java.util.Scanner;

public class Player {
    private ElementoMultimediale[] array = new ElementoMultimediale[5]; //definisco l'array che verrà popolato in seguito grazie al ciclo

    public void exec() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) { //ciclo necessario per inserire 5 oggetti nell'array contenente gli elementi multimediali
            System.out.print("Seleziona un elemento multimediale da creare tra 1-Audio, 2-Immagine o 3-Video: ");
            int elemento = scanner.nextInt();
            switch (elemento) { //switch utilizzato per mappare il tipo di oggetto che si vuole creare, previo inserimento da parte dell'utente
                case 1:
                    scanner.nextLine();//pulisco lo scanner
                    System.out.print("Inserisci il titolo della traccia: ");
                    String titoloAudio = scanner.nextLine(); //salvo il titolo
                    scanner.reset();//pulisco lo scanner
                    System.out.print("Inserisci la durata della traccia: ");
                    int durataAudio = scanner.nextInt();// salvo la durata
                    scanner.reset();//resetto lo scanner
                    System.out.print("Inserisci il volume della traccia (da 0 a 10): ");
                    int volumeAudio = scanner.nextInt();//salvo il volume
                    scanner.nextLine();//resetto lo scanner
                    array[i] = new Audio(titoloAudio, durataAudio, volumeAudio); //una volta ottenuti tutti i dati necessari per creare l'oggetto d'interesse, vado a pushare dentro l'array
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Inserisci il titolo dell'immagine: ");
                    String titoloImmagine = scanner.nextLine();
                    scanner.reset();
                    System.out.print("Inserisci la luminosità dell'immagine (da 1 a 10): ");
                    int luminositaImmagine = scanner.nextInt();
                    scanner.nextLine();
                    array[i] = new Immagine(titoloImmagine, luminositaImmagine);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Inserisci il titolo del video: ");
                    String titoloVideo = scanner.nextLine();
                    scanner.reset();
                    System.out.print("Inserisci la durata del video: ");
                    int durataVideo = scanner.nextInt();
                    scanner.reset();
                    System.out.print("Inserisci il volume del video (da 0 a 10): ");
                    int volumeVideo = scanner.nextInt();
                    scanner.reset();
                    System.out.print("Inserisci la luminosità del video (da 1 a 10): ");
                    int luminositaVideo = scanner.nextInt();
                    scanner.nextLine();
                    array[i] = new Video(titoloVideo, durataVideo, volumeVideo, luminositaVideo);
                    break;
                default:
                    System.out.println("Hai inserito un elemento errato.");
            }
        }

        int x = 1;
        do { //chiedo all'utente di scegliere l'elemento da riprodurre finchè non viene digitato 0
            System.out.print("Che elemento vuoi riprodurre (da 1 a 5 - 0 per terminare): ");
            int elemento = scanner.nextInt();
            if(elemento != 0) { //se l'utente inserisce 0 non viene eseguita la riga successiva, ed esce dal ciclo
                array[elemento - 1].esegui();
            };
            x = elemento;
        } while (x != 0);
    }
}