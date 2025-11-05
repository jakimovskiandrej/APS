package aud1;

import java.util.Scanner;

public class InsertionSort {
    public static void insertion(SLL<Integer> lista)
    {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> pom = null;
        while(dvizi!=null) {
            pom = dvizi.succ;
            while(pom!=null) {
                if(dvizi.element > pom.element) {
                    Integer temp = dvizi.element;
                    dvizi.element = pom.element;
                    pom.element = temp;
                }
                pom = pom.succ;
            }
            dvizi = dvizi.succ;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        insertion(lista);
        System.out.println(lista.toString());
    }
}
