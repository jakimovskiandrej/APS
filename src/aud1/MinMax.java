package aud1;

import java.util.Scanner;

public class MinMax {

    public static void minMax(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        int min = dvizi.element;
        int max = dvizi.element;

        while (dvizi != null) {
            if (dvizi.element < min) {
                min = dvizi.element;
            }
            if (dvizi.element > max) {
                max = dvizi.element;
            }
            dvizi = dvizi.succ;
        }

        SLL<Integer> pomali = new SLL<>();
        SLL<Integer> pogolemi = new SLL<>();
        dvizi = list.getFirst();

        while (dvizi != null) {
            int minDistance = Math.abs(dvizi.element - min);
            int maxDistance = Math.abs(dvizi.element - max);
            if (minDistance < maxDistance || minDistance == maxDistance) {
                pomali.insertLast(dvizi.element);
            } else {
                pogolemi.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }

        System.out.println(pomali);
        System.out.println(pogolemi);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL<Integer> lista = new SLL<>();
        int N = sc.nextInt();
        for(int i=0;i<N;i++)
        {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        minMax(lista);
    }
}
