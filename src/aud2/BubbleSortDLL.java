package aud2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BubbleSortDLL {

    public static void bubbleSort(DLL<Integer> list) {
        DLLNode<Integer> dvizi = list.getFirst();
        DLLNode<Integer> pom = null;
        while (dvizi != null) {
            pom = dvizi.succ;
            while (pom!=null) {
                if(dvizi.element > pom.element) {
                    Integer temp = dvizi.element;
                    dvizi.element = pom.element;
                    pom.element = temp;
                }
                pom = pom.succ;
            }
            dvizi = dvizi.succ;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        DLL<Integer> list = new DLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        bubbleSort(list);

        System.out.println(list);
    }

}