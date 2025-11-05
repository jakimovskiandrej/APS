package aud1;

import aud2.DLL;

import java.util.Scanner;

public class Naizmenichno {
    public static void naizmenichno(SLL<Integer> list1, SLL<Integer> list2) {
        SLLNode<Integer> dvizi1 = list1.getFirst();
        SLLNode<Integer> dvizi2 = list2.getFirst();

        SLL<Integer> result = new SLL<>();

        while (dvizi1 != null || dvizi2 != null) {
            for (int i = 0; i < 2 && dvizi1 != null; i++) {
                result.insertLast(dvizi1.element);
                dvizi1 = dvizi1.succ;
            }
            for (int i = 0; i < 2 && dvizi2 != null; i++) {
                result.insertLast(dvizi2.element);
                dvizi2 = dvizi2.succ;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        //todo: enter code here
        for(int i=0;i<n;i++) {
            list1.insertLast(scanner.nextInt());
        }

        SLL<Integer> list2 = new SLL<>();
        int M = scanner.nextInt();
        for(int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            list2.insertLast(a);
        }

        naizmenichno(list1,list2);
        //todo: enter code here
    }
}
