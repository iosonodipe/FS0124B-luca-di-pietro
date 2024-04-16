import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        stringaPariDispari();
//        annoBisestile();
//        stampaNumero();
        split();
    }

    public static String stringaPariDispari(){
        System.out.print("Digita una parola: ");
        String parola = new Scanner(System.in).nextLine();
        if (parola.length()%2 == 0) {
            System.out.print("Pari");
            return "Pari";
        }
        else return "Dispari";
    }

    public static void annoBisestile(){
        System.out.print("Digita l'anno: ");
        int anno = new Scanner(System.in).nextInt();
        if (anno%4 == 0) System.out.print("Anno bisestile");
        else if(anno%100 == 0 && anno%400 == 0) System.out.print("Anno bisestile");
        else System.out.print("Anno non bisestile");
    }

    public static void stampaNumero(){
        System.out.print("Digita un numero intero: ");
        int numero = new Scanner(System.in).nextInt();
        switch (numero){
            case 0:
                System.out.print("zero");
                break;
            case 1:
                System.out.print("uno");
                break;
            case 2:
                System.out.print("due");
                break;
            case 3:
                System.out.print("tre");
                break;
            default:
                System.out.print("Error");
        }
    }

    public static void split(){
        String input = "";
        while (!input.contains(":q")) {
            System.out.print("Digita una stringa: ");
            input = new Scanner(System.in).nextLine();
            String[] chars = input.split("");
            System.out.println(String.join(",", chars));
        }
    }
}