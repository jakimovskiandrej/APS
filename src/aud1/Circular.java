package aud1;

import java.util.Scanner;

public class Circular {
    public static void circularLinked(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> start = list.getFirst();
        while (start.succ != null) {
            start = start.succ;
        }

        start.succ = dvizi;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }
        sc.close();
        circularLinked(lista);
        System.out.println(lista.toString());
    }
}
