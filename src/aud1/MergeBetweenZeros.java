package aud1;

import java.util.Scanner;

public class MergeBetweenZeros {
    public static void mergeBetweenZeros(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLL<Integer> pom = new SLL<>();
        while(dvizi!=null) {
            int sum = 0;
            while(dvizi!=null && dvizi.element!=0) {
                sum+=dvizi.element;
                dvizi = dvizi.succ;
            }

            if(dvizi!=null) {
                if(sum!=0) {
                    pom.insertLast(sum);
                }
                dvizi = dvizi.succ;
            }
        }
        System.out.println(pom.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        //todo: enter code here
        for(int i=0;i<n;i++) {
            list1.insertLast(scanner.nextInt());
        }

        mergeBetweenZeros(list1);
        //todo: enter code here
    }
}
