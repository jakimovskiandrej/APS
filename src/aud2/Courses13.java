package aud2;

import java.util.*;
import java.io.*;

public class Courses13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        DLL<Integer> list = new DLL<>();
        DLLNode<Integer> dvizi = list.getFirst();
        int counter = 0;
        while (dvizi != null) {
            int sum = dvizi.element + dvizi.succ.element;
            double avg = (double)sum / N;
            if(avg > dvizi.element) {
                counter++;
            }
            dvizi = dvizi.succ;
        }
        System.out.println(counter);
    }
}
