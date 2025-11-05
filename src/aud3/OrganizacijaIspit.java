package aud3;

import java.util.*;
import java.util.Scanner;

public class OrganizacijaIspit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = Integer.parseInt(sc.nextLine());
        int N = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueBoth = new ArrayQueue<>(100);
        for(int i = 0; i < N; i++) {
            queueBoth.enqueue(sc.nextLine());
        }
        int M = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueAPS = new ArrayQueue<>(100);
        for(int i = 0; i < M; i++) {
            queueAPS.enqueue(sc.nextLine());
        }
        ArrayQueue<String> liars = new ArrayQueue<>(100);
        int K = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < K; i++) {
            liars.enqueue(sc.nextLine());
        }
        int termin = 1;
        while(!queueBoth.isEmpty() || !queueAPS.isEmpty()) {
            System.out.println(termin);
            int counter = 0;
            while(counter < capacity && !queueBoth.isEmpty()) {
                System.out.println(queueBoth.dequeue());
                counter++;
            }
            while(counter < capacity && !queueAPS.isEmpty()) {
                System.out.println(queueAPS.dequeue());
                counter++;
            }
            termin++;
        }
    }
}
