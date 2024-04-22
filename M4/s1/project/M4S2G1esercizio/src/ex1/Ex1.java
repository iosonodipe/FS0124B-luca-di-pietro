package ex1;

import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    private int[] array = new int[5];

    public Ex1(){
        for (int i = 0; i < array.length; i++){
            array[i] = new Random().nextInt(11);
        }
        System.out.println("Numeri array: ");
        stampaArray();
        System.out.println("----------------");
    }

    public void stampaArray(){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public void inserisciNuovoNumero(){
        Scanner scanner = new Scanner(System.in);
        int numero;
        int posizione;
        boolean check = true;

        do {
            System.out.print("Inserisci un nuovo numero: ");
            numero = scanner.nextInt();
            if (numero != 0) {
                scanner.nextLine();
                System.out.print("In che posizione? ");
                posizione = scanner.nextInt();
                if (posizione > 5) throw new LimiteArrayException("Posizione array non esistente");
                scanner.nextLine();
                array[posizione-1] = numero;
                stampaArray();
                System.out.println("----------------");
            } else check = false;
        } while (check);
    }
}
