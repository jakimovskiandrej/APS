package aud2;

import java.util.Scanner;

public class LastKElements {

    public static void lastKEelements(DLL<Integer> list, int k) {
        DLLNode<Integer> rear = list.getLast();
        int counter = 0;

        while (rear != null && counter < k) {
            list.insertFirst(rear.element);
            rear = rear.pred;
            counter++;
        }

        rear = list.getLast();
        counter = 0;
        while (rear != null && counter < k) {
            DLLNode<Integer> temp = rear.pred;
            list.delete(rear);
            rear = temp;
            counter++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<Integer>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int k = sc.nextInt();
        sc.close();

        lastKEelements(lista,k);
        System.out.println(lista);
    }
}
