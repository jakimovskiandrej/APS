package aud2;

import java.util.Scanner;

public class LongestPalindrome {
    public static int longestPalindrome(DLL<Integer> lista) {
        DLLNode<Integer> dvizi = lista.getFirst();
        int maxLength = 0;
        while(dvizi!=null) {
            int len = 1;
            DLLNode<Integer> poceten = dvizi.succ;
            DLLNode<Integer> posleden = dvizi.succ;
            while(poceten!=null && posleden!=null && dvizi.element.equals(poceten.element)) {
                len+=2;
                poceten = poceten.succ;
                if(posleden.succ!=null)
                    posleden = posleden.succ;
                else {
                    break;
                }
                maxLength = Math.max(maxLength, len);
            }
            dvizi = dvizi.succ;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        longestPalindrome(list);
        System.out.println(list);
    }
}
