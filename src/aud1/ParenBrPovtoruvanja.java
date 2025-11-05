package aud1;

import java.util.Scanner;

public class ParenBrPovtoruvanja {
    public static void paren(SLL<Integer> list, int x) {
        SLLNode<Integer> dvizi = list.getFirst();
        int counter = 0;
        SLLNode<Integer> pom = null;
        while (dvizi!=null) {
            if(dvizi.element == x) {
                pom = dvizi;
                counter++;
            }
            dvizi = dvizi.succ;
        }

        if(counter%2!=0) {
            list.delete(pom);
            System.out.println(list.toString());
        }

        if(counter%2==0) {
            System.out.println(list.toString());
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

        int x = sc.nextInt();
        sc.close();

        paren(lista,x);
    }
}
