package aud2;

import java.util.Scanner;

public class RemoveNthNode {
    public static void nthNode(DLL<Integer> list, int n) {
        DLLNode<Integer> dvizi = list.getLast();
        int counter = 1;
        while(dvizi!=null) {
            if(counter == n) {
                list.delete(dvizi);
                break;
            } else {
                counter++;
            }
            dvizi = dvizi.pred;
        }
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int k = sc.nextInt();

        nthNode(lista,k);
    }
}
