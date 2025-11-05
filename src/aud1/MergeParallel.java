package aud1;

import java.util.Scanner;

public class MergeParallel {
    public static void bubbleSort(SLL<Integer> list1, SLL<Integer> list2) {
        SLLNode<Integer> dvizi = list1.getFirst();
        SLLNode<Integer> dvizi2 = list2.getFirst();

        SLL<Integer> result = new SLL<>();

        while (dvizi != null) {
            result.insertLast(dvizi.element);
            dvizi = dvizi.succ;
        }

        while (dvizi2 != null) {
            result.insertLast(dvizi2.element);
            dvizi2 = dvizi2.succ;
        }

        SLLNode<Integer> dviziResult = result.getFirst();
        SLLNode<Integer> next = null;

        while(dviziResult!=null)
        {
            next = dviziResult.succ;
            while(next!=null)
            {
                if(dviziResult.element > next.element)
                {
                    Integer tmp = dviziResult.element;
                    dviziResult.element = next.element;
                    next.element = tmp;
                }
                next = next.succ;
            }
            dviziResult = dviziResult.succ;
        }

        System.out.println(result.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        SLL<Integer> lista2 = new SLL<>();
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            lista2.insertLast(a);
        }

        bubbleSort(lista,lista2);
    }
}
