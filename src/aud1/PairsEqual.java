package aud1;

import java.util.Scanner;

public class PairsEqual {
    public static void pairsEqual(SLL<Integer> list1, SLL<Integer> list2, int x) {
        SLLNode<Integer> dvizi = list1.getFirst();
        SLLNode<Integer> dvizi2 = list2.getFirst();
        int counter = 0;

        while(dvizi != null && dvizi2 != null) {
            if(dvizi.element + dvizi2.element == x) {
                counter++;
            }
            if(dvizi.element + dvizi2.succ.element == x) {
                counter++;
            }
            if(dvizi.succ.element + dvizi2.element == x) {
                counter++;
            }
            if(dvizi.succ.element + dvizi2.succ.element == x) {
                counter++;
            }

            dvizi = dvizi.succ;
            dvizi2 = dvizi2.succ;
        }
        System.out.println(counter);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        SLL<Integer> lista2 = new SLL<>();
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            lista2.insertLast(a);
        }

        int x = sc.nextInt();
        pairsEqual(lista,lista2,x);
    }
}
