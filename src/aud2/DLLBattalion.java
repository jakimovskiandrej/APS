package aud2;

import java.util.Scanner;

public class DLLBattalion {

    //TODO: implement function
    public static void battalion(DLL<Integer> list, int a, int b) {
        DLLNode<Integer> dvizi = list.getFirst();
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
            list.insertBefore(rear.element,front);
            list.delete(rear);
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

        battalion(list, a, b);

        System.out.println(list);
    }
}