package aud1;

import java.util.Scanner;

public class MiddleLinkedLIst {
    public static void middle(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = null;
        int counter = 0;
        while (dvizi!=null) {
            counter++;
            dvizi = dvizi.succ;
        }

        int middle = counter/2;
        if(list.size() % 2 == 0) {
            System.out.println(middle);
        } else {
            System.out.println(middle);
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

        middle(list1);
    }
}
