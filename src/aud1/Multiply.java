package aud1;

import aud2.DLL;

import java.util.Scanner;

public class Multiply {
    public static void multiplyLinkedLists(SLL<Integer> list1, SLL<Integer> list2) {
        SLLNode<Integer> dvizi = list1.getFirst();
        SLLNode<Integer> dvizi2 = list2.getFirst();
        SLL<Integer> rez = new SLL<>();

        while(dvizi!=null) {

            dvizi = dvizi.succ;
        }
        System.out.println(rez);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int m = sc.nextInt();
        SLL<Integer> list2 = new SLL<Integer>();
        for (int i = 0; i < m; i++) {
            list2.insertLast(sc.nextInt());
        }
        sc.close();
        multiplyLinkedLists(list,list2);
    }
}
