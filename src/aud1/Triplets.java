package aud1;

import java.util.Scanner;

public class Triplets {
    public static int triplets(SLL<Integer> lista, int key) {
        SLLNode<Integer> dvizi = lista.getFirst();
        int counter = 0;

        while(dvizi!=null) {
            SLLNode<Integer> second = dvizi.succ;
            while(second!=null) {
                SLLNode<Integer> third = second.succ;
                while(third!=null) {
                    int sum = dvizi.element + second.element + third.element;
                    if(sum == key) {
                        counter++;
                    }
                    third = third.succ;
                }
                second = second.succ;
            }
            dvizi = dvizi.succ;
        }
        return counter;
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
        System.out.println(triplets(lista,key));
    }
}
