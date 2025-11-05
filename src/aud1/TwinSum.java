package aud1;

import java.util.Scanner;

public class TwinSum {
    public static void twin(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = list.getFirst();

        while (pom!=null && pom.succ!=null) {
            dvizi = dvizi.succ;
            pom = pom.succ.succ;
        }

        SLLNode<Integer> prev = null;
        SLLNode<Integer> curr = dvizi;

        while (curr!=null) {
            SLLNode<Integer> next = curr.succ;
            curr.succ = prev;
            prev = curr;
            curr = next;
        }

        int maxTwin = Integer.MIN_VALUE;
        SLLNode<Integer> firstHalf = list.getFirst();
        SLLNode<Integer> secondHalf = prev;

        while (secondHalf!=null) {
            int twinSum = firstHalf.element + secondHalf.element;
            if(twinSum > maxTwin) {
                maxTwin = twinSum;
            }
            firstHalf = firstHalf.succ;
            secondHalf = secondHalf.succ;
        }

        System.out.println(maxTwin);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        twin(lista);
    }
}
