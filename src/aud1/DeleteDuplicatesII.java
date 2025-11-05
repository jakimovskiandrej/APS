package aud1;

import java.util.Scanner;

public class DeleteDuplicatesII {

    public static void deleteDuplicates2(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        SLLNode<Integer> pom = null;

        while (dvizi!=null) {
            pom = dvizi.succ;
            int flag = 0;
            while (pom!=null) {
                if(dvizi.element.equals(pom.element)) {
                    list.delete(pom);
                    flag = 1;
                }
                pom = pom.succ;
            }
            if(flag==1) {
                list.delete(dvizi);
            }
            dvizi = dvizi.succ;
        }

    }

    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<n;i++) {
            lista.insertLast(input.nextInt());
        }

        deleteDuplicates2(lista);
        System.out.println(lista);
    }
}
