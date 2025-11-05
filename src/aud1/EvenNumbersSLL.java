package aud1;

import java.util.*;

public class EvenNumbersSLL {
    public static int evenNumbers(SLL<Integer> list)
    {
        SLLNode<Integer> tmp = list.getFirst();
        int counter = 0;
        while(tmp!=null)
        {
            if(tmp.element%2==0)
            {
                counter++;
            }
            tmp = tmp.succ;
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the list");
        int n = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        System.out.println("Enter the elements of the list");
        for(int i=0;i<n;i++)
        {
            list.insertLast(sc.nextInt());
        }
        System.out.println("Number of even elements in the list is: " +evenNumbers(list));
    }
}
