package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KolokPrevrtiLista {
    public static void main(String[] args) throws IOException {
        DLL<Integer> lista = new DLL<Integer>(), pomosna = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        DLLNode<Integer> dvizi = lista.getFirst();
        while(dvizi!=null) {
            if(dvizi.element % 2 == 0) {
                pomosna.insertFirst(dvizi.element);
            }
            dvizi = dvizi.succ;
        }

        dvizi = lista.getLast();
        while(dvizi!=null) {
            if(dvizi.element % 2 != 0) {
                pomosna.insertLast(dvizi.element);
            }
            dvizi = dvizi.pred;
        }

        System.out.println(pomosna);
    }
}
