package aud1;

import java.util.Scanner;

public class Posledovatelno {

    public static void posledovatelno(SLL<Integer> list, int m, int n) {
        SLLNode<Integer> dvizi = list.getFirst();

        while(dvizi!=null) {
            for(int i=0;i<m && dvizi!=null;i++) {
                dvizi = dvizi.succ;
            }
            for(int i=0;i<n && dvizi!=null;i++) {
                SLLNode<Integer> toDelete = dvizi;
                dvizi = dvizi.succ;
                list.delete(toDelete);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<Integer> lista = new SLL<>();
        int N = sc.nextInt();
        for(int i=0;i<N;i++)
        {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int m = sc.nextInt();
        int n = sc.nextInt();
        posledovatelno(lista,m,n);
        System.out.println(lista);
    }
}
