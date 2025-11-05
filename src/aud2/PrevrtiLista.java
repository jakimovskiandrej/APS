package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PrevrtiLista {
    public static void prevrtiLista(DLL<Integer> lista){
        DLLNode<Integer> dvizi = lista.getLast();
        DLL<Integer> result = new DLL<>();

        while(dvizi != null) {
            if(dvizi.element%2==0) {
                result.insertLast(dvizi.element);
            }
            dvizi = dvizi.pred;
        }

        dvizi = lista.getLast();

        while(dvizi!=null) {
            if(dvizi.element%2!=0) {
                result.insertLast(dvizi.element);
            }
            dvizi = dvizi.pred;
        }

        System.out.println(result);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        DLL<Integer> lista = new DLL<Integer>();
        int N = Integer.parseInt(s);
        s = br.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }
        prevrtiLista(lista);
    }
}
