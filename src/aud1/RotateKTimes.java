package aud1;

import java.util.Scanner;

public class RotateKTimes {
    public static void kTimes(SLL<Integer> list, int k) {
        SLLNode<Integer> dvizi = list.getFirst();
        int len = 1;
        while(dvizi.succ!=null) {
            dvizi = dvizi.succ;
            len++;
        }

        k = k % len;
        int step = len - k;
        dvizi = list.getFirst();
        for(int i=1;i<step;i++) {
            dvizi = dvizi.succ;
        }
        SLLNode<Integer> newStep = null;
        newStep = dvizi;
        SLLNode<Integer> newHead = newStep.succ;

        newStep.succ = null;
        dvizi = newHead;
        while(dvizi.succ!=null) {
            dvizi = dvizi.succ;
        }
        dvizi.succ = list.getFirst();
        list.insertFirst(newHead.element);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }
        int key = sc.nextInt();
        kTimes(lista, key);
        System.out.println(lista);
    }
}
