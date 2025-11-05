package aud1;

import java.util.Scanner;

public class nKthNode {
    public static void findNode(SLL<Integer> list, int k) {
        SLLNode<Integer> dvizi = list.getFirst();
        int counter = 0;
        while(dvizi!=null) {
            counter++;
            dvizi = dvizi.succ;
        }

        int index = (int) Math.ceil((double) counter / k);

        dvizi = list.getFirst();
        for(int i=1;i<index;i++) {
            if(dvizi!=null) {
                dvizi = dvizi.succ;
            }
        }

        if(dvizi!=null) {
            System.out.println(dvizi.element);
        } else {
            System.out.println("-1");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        //todo: enter code here
        for(int i=0;i<n;i++) {
            list1.insertLast(scanner.nextInt());
        }

        int k = scanner.nextInt();
        findNode(list1,k);
        //todo: enter code here
    }
}
