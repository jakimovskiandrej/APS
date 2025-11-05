package aud2;

import java.util.Scanner;

public class Palindrom {
    public static boolean isItPalindrome(DLL<Integer> list){
        DLLNode<Integer> poceten = list.getFirst();
        DLLNode<Integer> posleden = list.getLast();
        while((poceten!=posleden) && (poceten.pred!=posleden)){
            if(!poceten.element.equals(posleden.element)){
                return false;
            }
            poceten = poceten.succ;
            posleden = posleden.pred;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        sc.close();
        System.out.println(isItPalindrome(list));
    }
}
