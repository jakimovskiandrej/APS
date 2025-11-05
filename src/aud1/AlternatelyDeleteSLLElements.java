package aud1;

import java.util.Scanner;

public class AlternatelyDeleteSLLElements {

    // TODO: implement function
    public static void keepDelete(SLL<Integer> list, int m, int n)
    {
        SLLNode<Integer> dvizi = list.getFirst();
        while(dvizi!=null)
        {
            for(int i=1;i<m && dvizi!=null;i++)
            {
                dvizi = dvizi.succ;
            }
            if(dvizi==null)
            {
                break;
            }
            SLLNode<Integer> next = dvizi.succ;
            for(int i=0;i<n && next!=null;i++)
            {
                next = next.succ;
            }
            dvizi.succ = next;
            dvizi = next;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int numElements;
        SLL<Integer> list1 = new SLL<Integer>();
        numElements = scan.nextInt();
        for(int i = 0; i<numElements; i++) {
            list1.insertLast(scan.nextInt());
        }
        int m = scan.nextInt();
        int n = scan.nextInt();
        keepDelete(list1,m,n);
        System.out.println(list1);

    }
}