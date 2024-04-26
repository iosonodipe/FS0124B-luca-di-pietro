package ex1;

import java.util.*;

public class Ex1 {
    private Set<String> distinte = new HashSet<>();
    private Set<String> duplicate = new HashSet<>();

    public Ex1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quante parole vuoi inserire? ");
        int numeroParole = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<numeroParole; i++){
            System.out.print("Digita la parola: ");
            String parola = scanner.nextLine();
            if(!distinte.add(parola)) duplicate.add(parola);
            distinte.add(parola);
        }
        System.out.println("Parole duplicate:");
        for (String duplicata: duplicate) System.out.println(duplicata);
        System.out.println("Parole distinte " + distinte.size() + ":");
        for (String distinta: distinte) System.out.println(distinta);
    }
}
