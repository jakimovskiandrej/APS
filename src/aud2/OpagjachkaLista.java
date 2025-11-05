package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpagjachkaLista {
    public static void opagjachka(DLL<Integer> lista, DLL<Integer> lista2) {
        DLLNode<Integer> dvizi = lista.getFirst();
        DLLNode<Integer> dvizi2 = lista2.getFirst();

        DLL<Integer> rez = new DLL<>();
        while (dvizi != null && dvizi2 != null) {
            DLLNode<Integer> pom = dvizi.succ;
            DLLNode<Integer> pom2 = dvizi2.succ;
            while(pom!=null) {
                if(dvizi.element < pom.element) {
                    Integer temp = dvizi.element;
                    dvizi.element = pom.element;
                    pom.element = temp;
                }
                rez.insertLast(pom.element);
                pom = pom.succ;
            }
            while (pom2!=null) {
                if(dvizi2.element < pom2.element) {
                    Integer temp = dvizi2.element;
                    dvizi2.element = pom2.element;
                    pom2.element = temp;
                }
                rez.insertLast(pom2.element);
                 pom2 = pom2.succ;
            }
            dvizi = dvizi.succ;
            dvizi2 = dvizi2.succ;
        }
        System.out.println(rez);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        DLL<Integer> lista = new DLL<>();
        DLL<Integer> lista2 = new DLL<>();
        int N = Integer.parseInt(s);
        s = br.readLine();
        String[] split = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(split[i]));
        }
        int M = Integer.parseInt(br.readLine());
        s = br.readLine();
        split = s.split(" ");
        for (int i = 0; i < M; i++) {
            lista2.insertLast(Integer.parseInt(split[i]));
        }

        opagjachka(lista, lista2);
    }
}
