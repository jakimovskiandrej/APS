package aud2;

import java.util.Scanner;

public class Zadaca9 {
    public static void rotate(DLL<Integer> list1, int m, int k) {
        DLLNode<Integer> dvizi = list1.getFirst();
        DLLNode<Integer> pom = null;
        boolean flag = false;
        while (dvizi!=null) {
            if(dvizi.element.equals(m)) {
                pom = dvizi;
                flag = true;
                break;
            }
            dvizi = dvizi.succ;
        }

        if(!flag) {
            System.out.println("Elementot ne postoi vo listata");
        }

        for(int i=0;i<k;i++) {
            if (pom != null && pom.succ != null) {
                int temp = pom.element;
                pom.element = pom.succ.element;
                pom.succ.element = temp;
                pom = pom.succ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        System.out.println(lista);
        rotate(lista,m,k);
        System.out.println(lista);
    }
}
