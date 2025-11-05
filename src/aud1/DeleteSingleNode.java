package aud1;

import java.util.Scanner;

public class DeleteSingleNode {
    public static void deleteNode(SLL<Integer> list, int n) {
        SLLNode<Integer> dvizi = list.getFirst();
        int counter = 1;
        while(dvizi!=null) {
            if(counter==n) {
                list.delete(dvizi);
                break;
            }
            dvizi = dvizi.succ;
            counter++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }
        int x = sc.nextInt();
        sc.close();
        deleteNode(lista,x);
        System.out.println(lista.toString());
    }
}
