package aud2;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpoiListi {
    public static void main(String[] args) throws IOException {
        DLL<Integer> lista1 = new DLL<Integer>(), lista2 = new DLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }

        s = stdin.readLine();
        N = Integer.parseInt(s);
        s = stdin.readLine();
        pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }

        DLL<Integer> rezultat = new DLL<Integer>();
        DLLNode<Integer> dvizi1 = lista1.getFirst();
        DLLNode<Integer> dvizi2 = lista2.getLast();
        int pom = 0;

        while(dvizi1!=null || dvizi2!=null) {
            if(pom%2==0) {
                if(dvizi1!=null)
                {
                    if(dvizi1.element%2==0){
                        rezultat.insertLast(dvizi1.element);
                    }
                    dvizi1 = dvizi1.succ;
                }
            } else {
                if(dvizi2!=null) {
                    if(dvizi2.element%2==0){
                        rezultat.insertLast(dvizi2.element);
                    }
                    dvizi2 = dvizi2.pred;
                }
            }
            pom++;
        }

        dvizi1 = lista1.getFirst();
        dvizi2 = lista2.getLast();
        pom = 0;

        while(dvizi1!=null || dvizi2!=null) {
            if(pom%2==0) {
                if(dvizi1!=null)
                {
                    if(dvizi1.element%2!=0){
                        rezultat.insertLast(dvizi1.element);
                    }
                    dvizi1 = dvizi1.succ;
                }
            } else {
                if(dvizi2!=null) {
                    if(dvizi2.element%2!=0){
                        rezultat.insertLast(dvizi2.element);
                    }
                    dvizi2 = dvizi2.pred;
                }
            }
            pom++;
        }

        System.out.println(rezultat);
    }
}
