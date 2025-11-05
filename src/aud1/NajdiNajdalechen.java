package aud1;

import java.util.Scanner;

public class NajdiNajdalechen {
    public static void najdalechen(SLL<Integer> lista, int m)
    {
        SLLNode<Integer> dvizi = lista.getFirst();
        int max = 0;
        SLLNode<Integer> pom = null;
        while(dvizi!=null)
        {
            if(Math.abs(dvizi.element - m) > max)
            {
                max = Math.abs(dvizi.element - m);
                pom = dvizi;
            }
            dvizi = dvizi.succ;
        }
        lista.delete(pom);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int m = sc.nextInt();

        najdalechen(lista,m);
        System.out.println(lista.toString());
    }
}
