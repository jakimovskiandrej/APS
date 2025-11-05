package aud2;

import java.util.Scanner;

public class KthNodeFromEnd {
    public static void kthNode(DLL<Integer> list, int k) {
        DLLNode<Integer> dvizi = list.getLast();
        if(k > list.getSize()) {
            System.out.println("-1");
            return;
        }

        for(int i=1;i<k;i++) {
            dvizi = dvizi.pred;
        }

        System.out.println("The " + k + "th node from end is " + dvizi.element);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int k = sc.nextInt();

        kthNode(lista,k);
    }
}
