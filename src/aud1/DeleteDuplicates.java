package aud1;

import java.util.Scanner;

public class DeleteDuplicates {
    public static void deleteDuplicates(SLL<Integer> lista,int key)
    {
        SLLNode<Integer> dvizi = lista.getFirst();
        SLLNode<Integer> pom = null;
        while(dvizi!=null) {
            if(dvizi.element.equals(key))
            {
                pom = dvizi;
            }
            dvizi = dvizi.succ;
        }
        lista.delete(pom);
    }

    public static void main(String[] args)
    {
        SLL<Integer> lista = new SLL<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i=0;i<n;i++)
        {
            lista.insertLast(input.nextInt());
        }
        System.out.println("Vnesi kluch!");
        int key = input.nextInt();
        deleteDuplicates(lista,key);
        System.out.println(lista);

    }

}
