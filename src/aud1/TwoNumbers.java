package aud1;

import java.util.Scanner;

public class TwoNumbers {
    public static void sumOfDigits(SLL<Integer> list1, SLL<Integer> list2)
    {
        SLLNode<Integer> dvizi = list1.getFirst();
        SLLNode<Integer> dvizi2 = list2.getFirst();
        StringBuilder sb = new StringBuilder();

        while(dvizi!=null)
        {
            sb.append(dvizi.element);
            dvizi = dvizi.succ;
        }

        StringBuilder sb2 = new StringBuilder();

        while(dvizi2!=null)
        {
            sb2.append(dvizi2.element);
            dvizi2 = dvizi2.succ;
        }

        int teni = Integer.parseInt(sb.reverse().toString());
        int teni2 = Integer.parseInt(sb2.reverse().toString());
        String result = String.valueOf(teni+teni2);
        int i = 0;
        SLL<String> krajna = new SLL<>();

        while(true)
        {
            if(result.length() == i)
            {
                break;
            }
            krajna.insertFirst(String.valueOf(result.charAt(i)));
            i++;
        }

        System.out.println(krajna.toString());

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        SLL<Integer> lista = new SLL<>();
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            lista.insertLast(a);
        }

        SLL<Integer> lista2 = new SLL<>();
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            lista2.insertLast(a);
        }

        sumOfDigits(lista,lista2);
    }
}
