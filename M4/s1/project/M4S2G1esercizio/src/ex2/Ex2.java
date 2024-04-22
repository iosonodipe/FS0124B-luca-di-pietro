package ex2;

import java.util.Scanner;

public class Ex2 {
    private int km;
    private int litri;

    public void mostraDati(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quanti km hai percoso? ");
        km = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Quanti litri hai consumato? ");
        litri = scanner.nextInt();
        if (litri <= 0) throw new ZeroLitriException();
        scanner.nextLine();
        System.out.println("Consumo: " + (km/litri) + "km/l");
    }
}
