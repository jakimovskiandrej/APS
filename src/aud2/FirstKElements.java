package aud2;

import java.util.Scanner;

public class FirstKElements {

    public static void transformList(DLL<Integer> list, int k) {
        DLLNode<Integer> dvizi = list.getFirst();
        while (dvizi!=null && k-- > 0) {
            list.delete(dvizi);
            list.insertLast(dvizi.element);
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(list);
        transformList(list,k);
        System.out.println(list);
    }
}
