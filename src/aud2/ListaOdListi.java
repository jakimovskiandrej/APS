package aud2;

import java.util.Scanner;

public class ListaOdListi {

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        long p = 1;
        DLLNode<DLL<Integer>> dvizi = list.getFirst();
        while(dvizi!=null) {
            DLLNode<Integer> podJazol = dvizi.element.getFirst();
            long suma = 0;
            while(podJazol!=null) {
                suma+=podJazol.element;
                podJazol = podJazol.succ;
            }
            p*=suma;
            dvizi = dvizi.succ;
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }

}