package aud1;

import java.util.Scanner;

public class BinaryToInteger {
    public static void binary(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        int num = 0;
        while(dvizi!=null) {
            num = (num << 1) | dvizi.element;
            dvizi = dvizi.succ;
        }
        System.out.println(num);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        binary(lista);
    }
}
