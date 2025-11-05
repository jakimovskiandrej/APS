package aud1;

import java.util.Scanner;

public class ModifyList {
    public static void modify(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();

        int counter = 1;

        while (dvizi!=null) {
            SLLNode<Integer> pom = dvizi.succ;
            if(pom.succ == null) {
                break;
            }
            for (int i=0;i<counter;i++) {
                pom = pom.succ;
            }
            list.delete(pom);
            dvizi = dvizi.succ;
            counter++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        sc.close();
        modify(list);
        System.out.println(list);
    }
}
