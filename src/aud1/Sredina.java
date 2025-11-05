package aud1;

import java.util.Scanner;

public class Sredina {
    public static void sredina(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = list.getFirst();

        while (pom!=null && pom.succ!=null) {
            dvizi = dvizi.succ;
            pom = pom.succ.succ;
        }

        SLL<Integer> rez = new SLL<>();

        while (dvizi!=null) {
            rez.insertLast(dvizi.element);
            dvizi = dvizi.succ;
        }

        System.out.println(rez.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        sredina(lista);
    }
}
