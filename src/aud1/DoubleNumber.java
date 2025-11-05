package aud1;

import java.util.Scanner;

public class DoubleNumber {
    public static void doublingNumber(SLL<Integer> list1) {
        SLLNode<Integer> dvizi = list1.getFirst();
        int ostatok = 0;
        while(dvizi!=null) {
            int value = dvizi.element * 2 + ostatok;
            dvizi.element = value % 10;
            ostatok = value / 10;
            dvizi = dvizi.succ;
        }

        if(ostatok>0) {
            list1.insertLast(ostatok);
        }

        System.out.println(list1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        //todo: enter code here
        for(int i=0;i<n;i++) {
            list1.insertLast(scanner.nextInt());
        }

        doublingNumber(list1);
        //todo: enter code here
    }
}
