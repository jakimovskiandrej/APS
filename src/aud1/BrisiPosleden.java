package aud1;

import java.util.Scanner;

public class BrisiPosleden {
    public static void deleteDuplicates(SLL<Integer> list1, int key)
    {
        SLLNode<Integer> dvizi = list1.getFirst();
        SLLNode<Integer> pom = null;
        while(dvizi!=null)
        {
            if(dvizi.element.equals(key))
            {
                pom = dvizi;
            }
            dvizi = dvizi.succ;
        }
        list1.delete(pom);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL<Integer> list1 = new SLL<Integer>();

        //todo: enter code here
        for(int i=0;i<n;i++) {
            list1.insertLast(scanner.nextInt());
        }

        int x = scanner.nextInt();
        deleteDuplicates(list1,x);
        System.out.println(list1);
    }
}
