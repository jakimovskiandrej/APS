package aud1;

import java.util.Scanner;

public class DeleteSLL {

    public static void change(SLL<Integer> list, int br) {
        SLLNode<Integer> dvizi = list.getFirst();
        int counter = 0;

        while (dvizi != null) {
            if(dvizi.element.equals(br)) {
                counter++;
            }
            dvizi = dvizi.succ;
        }

        dvizi = list.getFirst();
        while (dvizi != null) {
            SLLNode<Integer> pom = null;
            if(dvizi.element.equals(br)) {
                pom = dvizi;
                if(counter % 2 != 0) {
                    list.insertBefore(br,pom);
                    break;
                }
            }
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n, broj;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list1.insertLast(scan.nextInt());
        }
        int br = scan.nextInt();
        change(list1,br);
        System.out.println(list1);


    }
}
