package aud1;

import java.util.Scanner;

public class ZigZag {
    public static void makeZigZag(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        while(dvizi!=null && dvizi.succ!=null) {
            SLLNode<Integer> pom = dvizi.succ;
            if(dvizi.element > 0 && pom.element > 0) {
                list.delete(pom);
            }
            if(dvizi.element < 0 && pom.element < 0) {
                int nov = Math.abs(dvizi.element);
                list.insertAfter(nov,dvizi);
                dvizi = dvizi.succ;
                pom = pom.succ;
            }
            if(dvizi.element == 0 || pom.element == 0) {
                list.delete(dvizi);
                list.delete(pom);
                dvizi = list.getFirst();
            }
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        makeZigZag(lista);
        System.out.println(lista);
    }
}
