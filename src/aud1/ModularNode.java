package aud1;

import java.util.Scanner;

public class ModularNode {
    public static void modular(SLL<Integer> list, int k) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = null;
        while(dvizi!=null) {
            if(dvizi.element % k == 0) {
                pom = dvizi;
            }
            dvizi = dvizi.succ;
        }
        System.out.println(pom.element);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int k = sc.nextInt();
        sc.close();
        modular(list,k);
    }
}
