package aud1;

import java.util.Scanner;

public class MergeTwoLists {
    public static void mergeLists(SLL<Integer> list1, SLL<Integer> list2) {
        SLLNode<Integer> dvizi = list1.getFirst();
        SLLNode<Integer> dvizi2 = list2.getFirst();
        SLL<Integer> rez = new SLL<>();

        while(dvizi!=null) {
            rez.insertLast(dvizi.element);
            dvizi = dvizi.succ;
        }

        while(dvizi2!=null) {
            rez.insertLast(dvizi2.element);
            dvizi2 = dvizi2.succ;
        }

        SLLNode<Integer> pom = rez.getFirst();
        SLLNode<Integer> pom2 = null;
        while(pom!=null) {
            pom2 = pom.succ;
            while(pom2!=null) {
                if(pom.element > pom2.element) {
                    Integer tmp = pom.element;
                    pom.element = pom2.element;
                    pom2.element = tmp;
                }
                pom2 = pom2.succ;
            }
            pom = pom.succ;
        }

        System.out.println(rez.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int M = sc.nextInt();
        SLL<Integer> lista2 = new SLL<>();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        mergeLists(lista,lista2);
    }
}
