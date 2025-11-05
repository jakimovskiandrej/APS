package aud1;

import java.util.Scanner;

public class ParniNeparni {
    public static void transformacija(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> evenStart = null;
        SLLNode<Integer> evenEnd = null;
        SLLNode<Integer> oddStart = null;
        SLLNode<Integer> oddEnd = null;

        while (dvizi!=null) {
            SLLNode<Integer> next = dvizi.succ;
            dvizi.succ = null;

            if(dvizi.element % 2 == 0) {
                if(evenStart == null) {
                    evenStart = dvizi;
                    evenEnd = evenStart;
                } else {
                    evenEnd.succ = dvizi;
                    evenEnd = evenEnd.succ;
                }
            } else {
                if(oddStart == null) {
                    oddStart = dvizi;
                    oddEnd = oddStart;
                } else {
                    oddEnd.succ = dvizi;
                    oddEnd = oddEnd.succ;
                }
            }
            dvizi = next;
        }

        dvizi = list.getFirst();

        if(evenStart != null) {
            list.insertLast(evenStart.element);
            evenEnd.succ = oddStart;
        } else {
            list.insertLast(oddStart.element);
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

        transformacija(lista);
    }
}
