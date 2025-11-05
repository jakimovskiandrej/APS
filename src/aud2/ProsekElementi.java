package aud2;

import java.util.Scanner;

public class ProsekElementi {

    public static int najdiElementi(DLL<Integer> list) {
        int n = list.getSize();
        DLLNode<Integer> dvizi = list.getFirst();
        int counter = 0;
        for(int i=0;i<n;i++) {
            int sumLeft=0,counterLeft=0;
            int sumRight=0,counterRight=0;
            DLLNode<Integer> pom = list.getFirst();
            for(int j=0;j<i;j++) {
                sumLeft+=pom.element;
                counterLeft++;
                pom = pom.succ;
            }
            if (dvizi != null) {
                pom = dvizi.succ;
            }
            while (pom!=null) {
                sumRight+=pom.element;
                counterRight++;
                pom = pom.succ;
            }
            double avgLeft = 0;
            if(counterLeft>0) {
                avgLeft = (double)sumLeft / counterLeft;
            }
            double avgRight = 0;
            if(counterRight>0) {
                avgRight = (double)sumRight / counterRight;
            }
            if(avgLeft>avgRight) {
                counter++;
            }
            dvizi = dvizi.succ;
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }
        sc.close();
        System.out.println(najdiElementi(lista));
    }

}
