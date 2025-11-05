package aud1;

import java.util.Scanner;

public class DeleteNodes {

    public static void removeNodes(SLL<Integer> list, SLL<Integer> rezultantna) {
        SLLNode<Integer> dvizi = rezultantna.getFirst();
        SLLNode<Integer> prev = null;

        while(dvizi!=null) {
            SLLNode<Integer> check = list.getFirst();
            boolean najde = false;
            while(check!=null) {
                if(dvizi.element.equals(check.element)) {
                    najde = true;
                    break;
                }
                check = check.succ;
            }
            if(najde) {
                if(prev == null) {
                    rezultantna.deleteFirst();
                    dvizi = rezultantna.getFirst();
                } else {
                    prev.succ = dvizi.succ;
                    dvizi = dvizi.succ;
                }
            } else {
                prev = dvizi;
                dvizi = dvizi.succ;
            }
        }
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
        removeNodes(list1,list2);
        System.out.println(list2);
    }
}
