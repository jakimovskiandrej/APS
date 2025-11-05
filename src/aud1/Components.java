package aud1;

import java.util.Scanner;

public class Components {
    public static int components(SLL<Integer> lista, SLL<Integer> lista2) {
        int counter = 0;
        SLLNode<Integer> dvizi = lista.getFirst();
        boolean flag = false;

        while (dvizi != null) {
            SLLNode<Integer> temp = lista2.getFirst();
            boolean najde = false;
            while(temp!=null) {
                if(temp.element.equals(dvizi.element)) {
                    najde = true;
                    break;
                }
                temp = temp.succ;
            }

            if(najde) {
                if(!flag) {
                    counter++;
                    flag = true;
                } else {
                    flag = false;
                }
            }
            dvizi = dvizi.succ;
        }
        return counter;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numElements;
        SLL<Integer> list1 = new SLL<Integer>();
        numElements = scan.nextInt();
        for(int i = 0; i<numElements; i++) {
            list1.insertLast(scan.nextInt());
        }
        int numElements2;
        SLL<Integer> list2 = new SLL<Integer>();
        numElements2 = scan.nextInt();
        for(int i = 0; i<numElements2; i++) {
            list2.insertLast(scan.nextInt());
        }
        System.out.println(components(list1,list2));
    }
}
