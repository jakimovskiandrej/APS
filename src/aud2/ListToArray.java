package aud2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListToArray {
    public static void traversal(DLL<Integer> list) {
        DLLNode<Integer> dvizi = list.getFirst();
        List<Integer> lista = new ArrayList<Integer>();
        while (dvizi != null) {
            lista.add(dvizi.element);
            dvizi = dvizi.succ;
        }
        DLLNode<Integer> posleden = list.getLast();
        List<Integer> listaPozadi = new ArrayList<>();
        while (posleden != null) {
            listaPozadi.add(posleden.element);
            posleden = posleden.pred;
        }
        System.out.println(lista);
        System.out.println(listaPozadi);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        sc.close();
        traversal(list);
    }
}
