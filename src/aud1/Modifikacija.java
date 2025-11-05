package aud1;

import java.util.Scanner;

public class Modifikacija {
    public static void pogolemPomal(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = null;
        while (dvizi!=null) {
            pom = dvizi;
            dvizi = dvizi.succ;
        }

        dvizi = list.getFirst();
        SLL<Integer> pomali = new SLL<>();
        SLL<Integer> pogolemi = new SLL<>();
        while (dvizi!=null) {
            if(dvizi.element > pom.element) {
                pogolemi.insertLast(dvizi.element);
            }
            if(dvizi.element < pom.element) {
                pomali.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }

        System.out.println(pogolemi.toString());
        System.out.println(pomali.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        pogolemPomal(lista);
    }
}
