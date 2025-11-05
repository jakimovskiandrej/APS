package aud2;

import java.util.Scanner;

public class Kolok2014 {
    public static void midElement(DLL<Integer> list) {
        DLLNode<Integer> dvizi = list.getFirst();
        int counter = 0;

        while (dvizi!=null) {
            counter++;
            dvizi = dvizi.succ;
        }

        dvizi = list.getFirst();
        DLLNode<Integer> mid = list.getFirst();
        for(int i=0;i<counter/2;i++) {
            mid = mid.succ;
        }

        DLL<Integer> pomali = new DLL<>();
        DLL<Integer> pogolemi = new DLL<>();
        while (dvizi!=null) {
            if(mid.element > dvizi.element) {
                pogolemi.insertLast(dvizi.element);
            } else {
                pomali.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }
        pogolemi.delete(mid);
        System.out.println(pogolemi.toString());
        System.out.println(pomali.toString());

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        sc.close();
        midElement(list);
    }
}
