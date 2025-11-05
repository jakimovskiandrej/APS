package aud2;

import java.util.Scanner;

public class SwapFirstLast {
    public static void swapFirstLast(DLL<Integer> list1)
    {
        DLLNode<Integer> prv = list1.getFirst();
        DLLNode<Integer> posleden = list1.getLast();

        while(prv!=null && posleden!=null)
        {
            Integer pom = prv.element;
            prv.element = posleden.element;
            posleden.element = pom;
            prv = prv.succ;
            posleden = posleden.pred;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        DLL<Integer> list1 = new DLL<Integer>();

        //todo: enter code here
        for(int i=0;i<n;i++) {
            list1.insertLast(scanner.nextInt());
        }

        swapFirstLast(list1);
        System.out.println(list1);
    }
}

