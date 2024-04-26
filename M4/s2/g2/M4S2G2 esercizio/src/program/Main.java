package program;

import ex1.Ex1;
import ex2.Ex2;

public class Main {
    public static void main(String[] args) {
//        Ex1 ex1 = new Ex1();
//        System.out.println(Ex2.randomInt(5));
        System.out.println(Ex2.reverseInt(Ex2.generaLista(5, 100)));
        Ex2.pariDispari(Ex2.generaLista(6, 10), false);
    }
}