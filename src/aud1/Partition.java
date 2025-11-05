package aud1;

import java.util.Scanner;

public class Partition {
    public static void partition(SLL<Integer> lista, int x) {
        SLLNode<Integer> beforeStart = null;
        SLLNode<Integer> beforeEnd = null;
        SLLNode<Integer> afterStart = null;
        SLLNode<Integer> afterEnd = null;
        SLLNode<Integer> dvizi = lista.getFirst();
        
        while(dvizi!=null) {
            SLLNode<Integer> next = dvizi.succ;
            dvizi.succ = null;
            if(dvizi.element < x) {
                if(beforeStart==null) {
                    beforeStart = dvizi;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.succ = dvizi;
                    beforeEnd = dvizi;
                }
            } else {
                if(afterStart==null) {
                    afterStart = dvizi;
                    afterEnd = afterStart;
                } else {
                    afterEnd.succ = dvizi;
                    afterEnd = dvizi;
                }
            }
            dvizi = next;
        }

        if(beforeStart==null) {
            lista.insertFirst(afterStart.element);
        } else {
            lista.insertFirst(beforeStart.element);
            beforeEnd.succ = afterStart;
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
        int x = sc.nextInt();
        sc.close();
        partition(lista,x);
        System.out.println(lista.toString());
    }
}
