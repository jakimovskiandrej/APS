package aud1;

import java.util.Scanner;

public class Ascending {
    public static void ascOrder(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = null;
        while(dvizi!=null)
        {
            pom = dvizi.succ;
            while(pom!=null)
            {
                if(dvizi.element > pom.element) {
                    Integer tmp = dvizi.element;
                    dvizi.element = pom.element;
                    pom.element = tmp;
                }
                pom = pom.succ;
            }
            dvizi = dvizi.succ;
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

        ascOrder(lista);
        System.out.println(lista);
    }
}
