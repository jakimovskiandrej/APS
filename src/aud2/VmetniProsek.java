package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VmetniProsek {
    public static void main(String[] args) throws IOException {

        DLL<Integer> lista = new DLL<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        s = br.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        DLLNode<Integer> dvizi = lista.getFirst();

        while(dvizi!=null && dvizi.succ!=null) {
            float a = dvizi.element;
            float b = dvizi.succ.element;
            Integer nov = Math.round((a+b)/2);
            lista.insertAfter(nov,dvizi);
            dvizi = dvizi.succ;
        }

        dvizi = lista.getFirst();
        while(dvizi!=null) {
            System.out.println(dvizi.element + " ");
            dvizi = dvizi.succ;
        }

    }
}
