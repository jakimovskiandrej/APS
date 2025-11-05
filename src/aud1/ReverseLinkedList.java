package aud1;

import java.util.Scanner;

public class ReverseLinkedList {
    public static void reverseList(SLL<Integer> list, int left, int right)
    {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> prev = dvizi;

        for(int i=1;i<left;i++) {
            prev = prev.succ;
        }

        SLLNode<Integer> start = prev.succ;
        SLLNode<Integer> then = start.succ;

        for(int i=0;i<right-left;i++) {
            start.succ = then.succ;
            then.succ = prev.succ;
            prev.succ = then;
            then = start.succ;
        }

        if(left==1) {
            list.insertFirst(dvizi.succ.element);
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

        int left = scanner.nextInt();
        int right = scanner.nextInt();

        reverseList(list1,left,right);
        //todo: enter code here
        System.out.println(list1);

    }
}
