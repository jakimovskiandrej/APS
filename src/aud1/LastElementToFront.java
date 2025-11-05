package aud1;

import java.util.Scanner;

public class LastElementToFront {
    public static void lastToFront(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = null;
        while(dvizi!=null) {
            pom = dvizi;
            dvizi = dvizi.succ;
        }

        list.insertFirst(pom.element);
        list.delete(pom);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        sc.close();
        lastToFront(list);
        System.out.println(list);
    }
}
