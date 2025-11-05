package aud1;

import java.util.Scanner;

public class ParniJazli {
    public static void deleteEven(SLL<Integer> list1) {
        //todo: enter code here
        SLLNode<Integer> dvizi = list1.getFirst();
        while(dvizi != null) {
            SLLNode<Integer> pom = list1.getFirst();
            int counter = 0;
            while(pom!=null) {
                if(pom.element.equals(dvizi.element))
                {
                    counter++;
                }
                    pom = pom.succ;
                }
            if(counter%2==0) {
                pom = list1.getFirst();
                while(pom!=null) {
                    if(pom.element.equals(dvizi.element)) {
                        list1.delete(pom);
                    }
                    pom = pom.succ;
                }
            }
                dvizi = dvizi.succ;
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

        deleteEven(list1);
        //todo: enter code here
        System.out.println(list1);
    }

}
