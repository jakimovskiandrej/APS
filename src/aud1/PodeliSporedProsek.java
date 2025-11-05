package aud1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PodeliSporedProsek {

    public static void podeli(SLL<Integer> lista){
        SLL<Integer> pomali = new SLL<Integer>(), pogolemi = new SLL<Integer>();
        SLLNode<Integer> dvizi = lista.getFirst();
        int suma = 0;
        int counter = 0;

        while(dvizi!=null) {
            suma+=dvizi.element;
            counter++;
            dvizi = dvizi.succ;
        }

        float avg = (float)suma/counter;
        dvizi = lista.getFirst();

        while(dvizi!=null) {
            if(dvizi.element<=avg) {
                pomali.insertLast(dvizi.element);
            } else {
                pogolemi.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }

        //Pechatenje na pomali i ednakvi od prosekot
        SLLNode<Integer> pom = pomali.getFirst();
        while (pom!=null) {
            System.out.print(pom.element);
            if(pom.succ!=null)
                System.out.print(" ");
            pom = pom.succ;
        }
        System.out.println();

        //Pechatenje na pogolemi od prosekot
        pom = pogolemi.getFirst();
        while (pom!=null) {
            System.out.print(pom.element);
            if(pom.succ!=null)
                System.out.print(" ");
            pom = pom.succ;
        }
        System.out.println();

    }

    public static void main(String[] args) throws IOException {
        SLL<Integer> lista = new SLL<Integer>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista.insertLast(Integer.parseInt(pomniza[i]));
        }

        podeli(lista);

    }
}
