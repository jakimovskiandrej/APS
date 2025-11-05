package aud2;

import java.util.*;

public class PalindromeDLL {
    public static int isPalindrome(DLL<Integer> list)
    {
        DLLNode<Integer> poceten = list.getFirst();
        DLLNode<Integer> posleden = list.getLast();

        while((poceten!=posleden) && (poceten.pred!=posleden))
        {
            if(!poceten.element.equals(posleden.element))
            {
                return -1;
            }
            poceten = poceten.succ;
            posleden = posleden.pred;
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<>();
        for(int i=0;i<n;i++)
        {
            list.insertLast(sc.nextInt());
        }
        sc.close();
        System.out.println(isPalindrome(list));
    }
}
