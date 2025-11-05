package aud1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RazdeliJazli {

    public static void razdeli(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLL<Integer> even = new SLL<>();
        SLL<Integer> odd = new SLL<>();

        while (dvizi!=null) {
            while (dvizi.succ!=null && dvizi.element%2==0 && dvizi.succ.element%2==0) {
                dvizi = dvizi.succ;
            }
            while (dvizi.succ!=null && !(dvizi.element%2==0) && !(dvizi.succ.element%2==0)) {
                dvizi = dvizi.succ;
            }
            if(dvizi.element%2==0) {
                even.insertLast(dvizi.element);
            } else {
                odd.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }
        System.out.println(even);
        System.out.println(odd);
    }

    public static void main(String[] args) throws IOException {
        SLL<Integer> lista = new SLL<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        s = br.readLine();
        String[] pomniza = s.split(" ");
        for (int i=0;i<N;i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        razdeli(lista);
    }
}
