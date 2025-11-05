package aud1;

import java.util.Scanner;

public class DeleteMiddle {
    public static void izbrishiSredina(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = list.getFirst();
        int counter = 0;

        while(dvizi!=null) {
            counter++;
            dvizi = dvizi.succ;
        }

        int midIndex = counter/2;
        for(int i=0; i<midIndex - 1; i++) {
            pom = pom.succ;
        }
        pom.succ = pom.succ.succ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        izbrishiSredina(list);
        System.out.println(list);
    }
}
