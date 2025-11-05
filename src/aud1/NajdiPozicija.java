package aud1;

import java.util.Scanner;

public class NajdiPozicija {
    public static void pozicija(SLL<Integer> list, int x)
    {
        SLLNode<Integer> dvizi = list.getFirst();
        int counter = 0;
        while(dvizi!=null)
        {
            counter++;
            if(dvizi.element.equals(x))
            {
                list.insertFirst(x);
                break;
            }
            dvizi = dvizi.succ;
        }
        System.out.println(counter);
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
        pozicija(list1,x);
    }
}
