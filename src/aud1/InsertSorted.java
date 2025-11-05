package aud1;

import java.util.Scanner;

public class InsertSorted {
    public static void insertSorted(SLL<Integer> list, int x) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = null;

        list.insertLast(x);
        while(dvizi!=null) {
            pom = dvizi.succ;
            while(pom!=null) {
                if(dvizi.element > pom.element) {
                    Integer tmp = dvizi.element;
                    dvizi.element = pom.element;
                    pom.element = tmp;
                }
                pom = pom.succ;
            }
            dvizi = dvizi.succ;
        }
        System.out.println(list);
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
        insertSorted(list1,k);
        //todo: enter code here
    }
}
