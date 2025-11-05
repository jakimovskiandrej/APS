package aud1;

import java.util.Scanner;

public class GCD {
    public static void insertCommon(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        while(dvizi!=null && dvizi.succ!=null) {
            int gcdVal = gcd(dvizi.element, dvizi.succ.element);
            SLLNode<Integer> newNode = new SLLNode<>(gcdVal, dvizi.succ);
            dvizi.succ = newNode;
            dvizi = newNode.succ;
        }
    }

    public static int gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        else {
            return gcd(b, a % b);
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

        insertCommon(list1);
        System.out.println(list1);
        //todo: enter code here
    }
}
