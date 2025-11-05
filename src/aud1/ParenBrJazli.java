package aud1;

import java.util.Scanner;

public class ParenBrJazli {
    public static void brishiJazli(SLL<Integer> lista) {
        SLLNode<Integer> dvizi = lista.getFirst();
        while(dvizi!=null) {
            SLLNode<Integer> tmp = lista.getFirst();
            int counter = 0;
            while(tmp != null) {
                if(dvizi.element.equals(tmp.element)) {
                    counter++;
                }
                tmp = tmp.succ;
            }
            if(counter % 2 == 0) {
                tmp = lista.getFirst();
                while(tmp!=null) {
                    if(tmp.element.equals(dvizi.element)) {
                        lista.delete(tmp);
                    }
                    tmp = tmp.succ;
                }
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

        brishiJazli(lista);
        System.out.println(lista);
    }
}
