package aud2;

import java.util.Scanner;

public class SumOfLastNodes {
    public static void sumLastNodes(DLL<Integer> list, int x) {
        DLLNode<Integer> dvizi = list.getLast();
        int sum = 0;
        int counter = 0;
        while (dvizi!=null) {
            sum+=dvizi.element;
            counter++;
            if(counter == x) {
                break;
            }
            dvizi = dvizi.pred;
        }

        System.out.println(sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int x = sc.nextInt();
        sc.close();
        sumLastNodes(list,x);
    }
}
