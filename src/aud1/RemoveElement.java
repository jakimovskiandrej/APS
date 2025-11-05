package aud1;

import java.util.Scanner;

public class RemoveElement {
    public static void removeElement(SLL<Integer> list, int key)
    {
        SLLNode<Integer> dvizi = list.getFirst();
        while(dvizi!=null)
        {
            if(dvizi.element.equals(key))
            {
                list.delete(dvizi);
            }
            dvizi = dvizi.succ;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        int key = sc.nextInt();

        removeElement(lista, key);
        System.out.println(lista.toString());
    }
}
