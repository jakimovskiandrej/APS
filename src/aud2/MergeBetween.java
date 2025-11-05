package aud2;

import java.util.Scanner;

public class MergeBetween {
    public static void merge(DLL<Integer> lista, DLL<Integer> lista2, int a, int b)
    {
        DLLNode<Integer> dvizi = lista.getFirst();
        DLLNode<Integer> dvizi2 = lista2.getFirst();
        DLLNode<Integer> pom = null;
        while(dvizi!=null && dvizi2!=null)
        {
            if(dvizi.succ.equals(a))
            {
                lista.insertAfter(dvizi2.element,dvizi);
            }
            dvizi = dvizi.succ;
            dvizi2 = dvizi2.succ;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int M = sc.nextInt();
        DLL<Integer> lista2 = new DLL<>();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            lista2.insertLast(a);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();

        merge(lista,lista2,a,b);
    }
}
