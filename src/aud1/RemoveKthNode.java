package aud1;

import java.util.Scanner;

public class RemoveKthNode {
    public static void removeKthNode(SLL<Integer> list, int k) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> prev = null;
        int counter = 1;
        while(dvizi!=null) {
            if(counter % k == 0) {
                if(prev!=null) {
                    prev.succ = dvizi.succ;
                } else {
                    list.insertFirst(dvizi.succ.element);
                }
            } else {
                prev = dvizi;
            }
            dvizi = dvizi.succ;
            counter++;
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
        removeKthNode(list1,k);
        //todo: enter code here
        System.out.println(list1);
    }
}
