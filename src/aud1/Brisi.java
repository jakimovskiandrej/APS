package aud1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Brisi {

    public static void brishiPrekuEden(SLL<Integer> list) {
        SLLNode<Integer> dvizi = list.getFirst();
        int counter = 1;
        while(dvizi!=null)
        {
            for(int i=1;i<counter && dvizi!=null;i++) {
                dvizi = dvizi.succ;
            }
            if(dvizi!=null && dvizi.succ!=null) {
                dvizi.succ = dvizi.succ.succ;
                dvizi = dvizi.succ;
            } else {
                break;
            }
            counter++;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int numElements = scan.nextInt();
        SLL<Integer> list1 = new SLL<Integer>();
        numElements = scan.nextInt();
        for(int i = 0; i<numElements; i++) {
            list1.insertLast(scan.nextInt());
        }
        brishiPrekuEden(list1);
        System.out.println(list1);
    }
}
