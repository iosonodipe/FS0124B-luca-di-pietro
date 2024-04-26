package ex2;

import java.util.*;

public class Ex2 {

    public static List<Integer> generaLista(int n, int ran){
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < n; i++){
            lista.add(new Random().nextInt(ran));
        }
        return lista;
    }

    public static List<Integer> randomInt(int n){
        List<Integer> random = generaLista(n, 101);
        Collections.sort(random);
        return random;
    }

    public static List<Integer> reverseInt(List<Integer> list){
        var reverseList = new ArrayList<Integer>();
        for (int i = list.size() - 1; i >= 0; i--){
            reverseList.add(list.get(i));
        }
        reverseList.addAll(list);
        return reverseList;
    }

    public static void pariDispari(List<Integer> list, boolean bool){
        for (int numero: list) System.out.print(numero + " ");
        if (bool){
            System.out.println("Numeri posizioni pari: ");
            for (int i = 0; i < list.size(); i++){
                if (i%2 != 0) System.out.print(list.get(i) + " ");
            }
        } else {
            System.out.println("Numeri posizioni dispari: ");
            for (int i = 0; i < list.size(); i++){
                if (i%2 == 0) System.out.print(list.get(i) + " ");
            }
        }
    }
}
