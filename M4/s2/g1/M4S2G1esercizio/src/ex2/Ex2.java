package ex2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2 {
    private int km;
    private int litri;
    private static final Logger logger = LoggerFactory.getLogger(Ex2.class);


    public void mostraDati(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quanti km hai percoso? ");
        km = scanner.nextInt();
        scanner.nextLine();
        boolean riprova = true;
        while(riprova) {
            try {
                System.out.print("Quanti litri hai consumato? ");
                litri = scanner.nextInt();
                scanner.nextLine();
                if (litri <= 0) throw new ZeroLitriException();
                riprova = false;
            }catch(InputMismatchException e){
                logger.error("Devi inserire un numero.");
            }catch(ZeroLitriException e){
                logger.error("Non puoi inserire zero litri!");
            }
        }
        System.out.println("Consumo: " + (km/litri) + "km/l");
    }
}
