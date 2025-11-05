package aud2;

import aud1.SLL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NaizmenichnoTriJazli {
    public static void naizmenichnoTriJazli(DLL<Integer> list1, DLL<Integer> list2)
    {
        DLLNode<Integer> dvizi1 = list1.getFirst();
        DLLNode<Integer> dvizi2 = list2.getFirst();

        while(dvizi1!=null || dvizi2!=null)
        {
            for(int i=0;i<3 && dvizi1!=null;i++)
            {
                list1.insertLast(dvizi1.element);
                dvizi1 = dvizi1.succ;
            }
            for(int i=0;i<3 && dvizi2!=null;i++)
            {
                list1.insertLast(dvizi2.element);
                dvizi2 = dvizi2.succ;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        DLL<Integer> lista2 = new DLL<>();
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            lista2.insertLast(a);
        }
        naizmenichnoTriJazli(lista,lista2);
    }
}
