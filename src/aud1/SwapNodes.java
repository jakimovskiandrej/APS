package aud1;

import java.util.Scanner;

public class SwapNodes {
    public static void swapNodesInPairs(SLL<Integer> list1) {
        SLLNode<Integer> dvizi = list1.getFirst();

        while(dvizi!=null)
        {
            if(dvizi.succ==null)
            {
                break;
            }
            Integer teni = dvizi.element;
            dvizi.element = dvizi.succ.element;
            dvizi.succ.element = teni;
            dvizi = dvizi.succ.succ;
        }

        System.out.println(list1.toString());

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        swapNodesInPairs(lista);
    }
}
