package aud2;

import aud1.SLL;

import java.util.Scanner;

public class Modification {
    public static void modification(DLL<Integer> list) {
        DLLNode<Integer> front = list.getFirst();
        DLLNode<Integer> rear = list.getLast();

        while(front!=null && rear!=null) {
            int sum = 0;

            front = front.succ;
            rear = rear.pred;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        sc.close();
        modification(list);
        System.out.println(list);
    }
}
