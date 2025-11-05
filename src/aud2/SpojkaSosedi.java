package aud2;

import java.util.Scanner;

public class SpojkaSosedi {
    public static void spojka(DLL<Integer> list, int n) {
        DLLNode<Integer> dvizi = list.getFirst();
        while(dvizi!=null) {
            int vrednost = dvizi.element * 10 + dvizi.succ.element;
            if(vrednost > n) {
                dvizi.element = vrednost;
                DLLNode<Integer> toRemove = dvizi.succ;
                dvizi.succ = toRemove.succ;
                if(toRemove.succ != null) {
                    toRemove.succ.pred = dvizi;
                }
            }
            dvizi = dvizi.succ;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int broj = sc.nextInt();
        sc.close();
        spojka(list,broj);
        System.out.println(list);
    }
}
