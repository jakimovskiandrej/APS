package aud1;

import java.util.Scanner;

public class ZerosFirst {

    public static void zerosFirst(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = null;

        while (dvizi!=null) {
            if(dvizi.element.equals(0)) {
                pom = dvizi;
                list.insertFirst(dvizi.element);
                list.delete(pom);
            }
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<n;i++) {
            lista.insertLast(input.nextInt());
        }
        zerosFirst(lista);
        System.out.println(lista);
    }
}
