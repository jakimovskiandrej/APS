package aud1;

import java.util.Scanner;

public class OddEven {
    public static void oddEven(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        int counter = 1;
        while(dvizi!=null) {
            if(counter > list.size()) {
                break;
            }
            SLLNode<Integer> pom = null;
            if(counter%2==0) {
                pom = dvizi;
                list.insertLast(dvizi.element);
                list.delete(pom);
            }
            counter++;
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

        oddEven(lista);
        System.out.println(lista.toString());
    }
}
