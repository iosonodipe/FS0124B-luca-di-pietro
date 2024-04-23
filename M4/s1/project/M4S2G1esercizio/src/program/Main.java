package program;

import ex1.Ex1;
import ex1.LimiteArrayException;
import ex2.Ex2;
import ex2.ZeroLitriException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        try {
//            Ex1 ex1 = new Ex1();
//            ex1.inserisciNuovoNumero();
            Ex2 ex2 = new Ex2();
            ex2.mostraDati();
        } catch (LimiteArrayException e){
            logger.error("Posizione non esistente.");
        }

    }
}