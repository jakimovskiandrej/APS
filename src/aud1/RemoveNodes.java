package aud1;

import java.util.Scanner;

public class RemoveNodes {
    public static void removeNodes(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> sleden = dvizi;
        while(dvizi!=null && sleden.succ!=null) {
            if(dvizi.succ.element > dvizi.element) {
                sleden.succ = dvizi;
                list.delete(dvizi);
            } else {
                dvizi = dvizi.succ;
            }
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

        scanner.close();
        removeNodes(list1);
        System.out.println(list1);
    }
}
