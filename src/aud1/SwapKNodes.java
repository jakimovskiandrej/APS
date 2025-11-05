package aud1;

import java.util.Scanner;

public class SwapKNodes {
    public static void swapFirstLast(SLL<Integer> list, int k)
    {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> kthFromStart = null;
        SLLNode<Integer> kthFromEnd = null;

        int len = 0;
        while(dvizi!=null) {
            len++;
            dvizi = dvizi.succ;
        }

        int kFromStartIndex = k-1;
        int kFromEndIndex = len - k;

        dvizi = list.getFirst();
        int currIndex = 0;
        while(dvizi!=null) {
            if(currIndex==kFromStartIndex) {
                kthFromStart = dvizi;
            }
            if(currIndex==kFromEndIndex) {
                kthFromEnd = dvizi;
            }
            currIndex++;
            dvizi = dvizi.succ;
        }

        if(kthFromStart!=null && kthFromEnd!=null) {
            int temp = kthFromStart.element;
            kthFromStart.element = kthFromEnd.element;
            kthFromEnd.element = temp;
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

        int k = scanner.nextInt();
        scanner.close();
        swapFirstLast(list1,k);
        System.out.println(list1);
    }
}

