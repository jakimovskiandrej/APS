package aud2;

import java.util.Scanner;

public class ReorderList {
    public static void reorder(DLL<Integer> list)
    {
        DLLNode<Integer> prv = list.getFirst();
        DLLNode<Integer> posleden = list.getLast();
        DLL<Integer> res = new DLL<>();
        while(prv!=null && posleden!=null)
        {
            prv = list.getFirst();
            posleden = list.getLast();
            res.insertLast(prv.element);
            list.delete(prv);
            res.insertLast(posleden.element);
            list.delete(posleden);
            prv = prv.succ;
            posleden = posleden.pred;
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        reorder(lista);
    }
}
