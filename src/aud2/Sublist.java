package aud2;

import java.util.Scanner;

public class Sublist {
    public static void sublistReverse(DLL<Integer> lista, int a, int b) {
        DLLNode<Integer> dvizi = lista.getFirst();
        DLLNode<Integer> front = null;
        DLLNode<Integer> rear = null;

        while(dvizi!=null) {
            if(dvizi.element.equals(a)) {
                front = dvizi;
            }
            if(dvizi.element.equals(b)) {
                rear = dvizi;
            }
            dvizi = dvizi.succ;
        }

        while(rear!=front) {
            lista.insertBefore(rear.element,front);
            lista.delete(rear);
            rear = rear.pred;
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        DLL<Integer> list = new DLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int a = input.nextInt();
        int b = input.nextInt();

        sublistReverse(list, a, b);

        System.out.println(list);
        System.out.println(list.toStringR());
    }
}
