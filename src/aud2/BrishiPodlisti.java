package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrishiPodlisti {
    public static void brishiPodListi(DLL<Integer> lista, DLL<Integer> lista2) {
        DLLNode<Integer> dvizi = lista.getFirst();
        int len2 = lista2.getSize();

        while (dvizi != null) {
            DLLNode<Integer> curr1 = dvizi;
            DLLNode<Integer> curr2 = lista2.getFirst();
            boolean match = true;

            while (curr2 != null) {
                if (curr1 == null || !curr1.element.equals(curr2.element)) {
                    match = false;
                    break;
                }
                curr1 = curr1.succ;
                curr2 = curr2.succ;
            }

            if (match) {
                DLLNode<Integer> delStart = dvizi;
                for (int i = 0; i < len2; i++) {
                    DLLNode<Integer> sleden = delStart.succ;
                    lista.delete(delStart);
                    delStart = sleden;
                }
                dvizi = curr1;
            } else {
                dvizi = dvizi.succ;
            }
        }
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

        brishiPodListi(lista, lista2);
        System.out.println(lista);
    }
}