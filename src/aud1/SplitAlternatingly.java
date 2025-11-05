package aud1;

import java.util.Scanner;

public class SplitAlternatingly {
    public static void splitAlter(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLL<Integer> rez1 = new SLL<>();
        SLL<Integer> rez2 = new SLL<>();

        boolean flag = true;

        while (dvizi!=null) {
            if(flag) {
                rez1.insertLast(dvizi.element);
            } else {
                rez2.insertLast(dvizi.element);
            }
            flag = !flag;
            dvizi = dvizi.succ;
        }

        System.out.println(rez1.toString());
        System.out.println(rez2.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        sc.close();
        splitAlter(list);
    }
}
