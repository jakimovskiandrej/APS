package aud2;

import java.util.Scanner;

public class MagicnaLista {
    public static long findMagicNumber(DLL<DLL<Integer>> lista)
    {
        long p = 1;
        DLLNode<DLL<Integer>> dvizi = lista.getFirst();
        while(dvizi!=null)
        {
            DLLNode<Integer> podJazol = dvizi.element.getFirst();
            int suma = 0;
            while(podJazol!=null)
            {
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
