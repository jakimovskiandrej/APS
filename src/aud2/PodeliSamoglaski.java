package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PodeliSamoglaski {

    public static void podeliSamoglaski(DLL<Character> lista, DLL<Character> lsamoglaski, DLL<Character> lsoglaski) {
        DLLNode<Character> dvizi = lista.getFirst();
        while(dvizi!=null) {
            if(dvizi.element.equals('a') || dvizi.element.equals('e') || dvizi.element.equals('i') || dvizi.element.equals('o') || dvizi.element.equals('u')) {
                lsamoglaski.insertLast(dvizi.element);
            } else {
                lsoglaski.insertLast(dvizi.element);
            }
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) throws IOException {
        DLL<Character> lista = new DLL<Character>(), samoglaski = new DLL<Character>(), soglaski = new DLL<Character>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        for (int i = 0; i < s.length(); i++) {
            lista.insertLast(s.charAt(i));
        }

        podeliSamoglaski(lista, samoglaski, soglaski);

        // Pecatenje samoglaski
        DLLNode<Character> tmp = samoglaski.getFirst();
        while (tmp != null) {
            System.out.print(tmp.element);
            if (tmp.succ != null)
                System.out.print(" ");
            tmp = tmp.succ;
        }
        System.out.println();
        // Pecatenje soglaski
        tmp = soglaski.getFirst();
        while (tmp != null) {
            System.out.print(tmp.element);
            if (tmp.succ != null)
                System.out.print(" ");
            tmp = tmp.succ;
        }
        System.out.println();
    }

}
