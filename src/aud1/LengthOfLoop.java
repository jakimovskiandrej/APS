package aud1;

import java.util.Scanner;

public class LengthOfLoop {
    public static int loopLength(SLL<Integer> list, int c) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = null;
        int counter = 1;

        while (dvizi != null) {
            if(counter == c) {
                pom = dvizi;
            }
            dvizi = dvizi.succ;
            counter++;
        }


        SLLNode<Integer> slow = list.getFirst();
        SLLNode<Integer> fast = list.getFirst();

        while(fast != null && fast.succ != null) {
            slow = slow.succ;
            fast = fast.succ.succ;

            if(slow == fast) {
                int loopLen = 1;
                SLLNode<Integer> temp = slow;
                while(temp.succ != slow) {
                    loopLen++;
                    temp = temp.succ;
                }
                return loopLen;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int x = sc.nextInt();
        sc.close();
        System.out.println(loopLength(list, x));
    }
}
