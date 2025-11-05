package aud2;

import java.util.Scanner;

public class SubstringPalindrome {
    public static void shortestSubstring(DLL<Character> list) {
        DLLNode<Character> dvizi = list.getFirst();
        DLL<Character> rez = null;

        int flag = 1;
        DLLNode<Character> front = list.getFirst();
        DLLNode<Character> rear = list.getLast();

        while(front!=null && rear!=null && front != rear && front.succ != rear) {
            if(front.element != rear.element) {
                flag = 0;
            }
            front = front.succ;
            rear = rear.pred;
        }

        for(int i=0;i<list.getSize();i++) {
            DLLNode<Character> start = dvizi;
            for(int j=0;j<list.getSize();j++) {
                DLL<Character> substring = new DLL<>();
                DLLNode<Character> temp = start;
                for(int k=i;k<=j;k++) {
                    substring.insertLast(temp.element);
                    temp = temp.succ;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        DLL<Character> list1 = new DLL<Character>();

        //todo: enter code here
        for(int i=0;i<N;i++) {
            list1.insertLast(scanner.next().charAt(0));
        }

        shortestSubstring(list1);
        //todo: enter code here
    }
}
