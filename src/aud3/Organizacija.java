package aud3;

import java.util.Scanner;

public class Organizacija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueTest = new ArrayQueue<>(100);
        for(int i = 0; i < N; i++) {
            queueTest.enqueue(sc.nextLine());
        }
        int M = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueExercises = new ArrayQueue<>(100);
        for(int i = 0; i < M; i++) {
            queueExercises.enqueue(sc.nextLine());
        }
        int K = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueBoth = new ArrayQueue<>(100);
        for(int i = 0; i < K; i++) {
            queueBoth.enqueue(sc.nextLine());
        }
        int capacity = 20;
        int termin = 1;
        int counter = 0;
        System.out.println("Polagaat e-test:");
        System.out.println("termin " + termin);
        while (!queueTest.isEmpty()) {
            if(counter == capacity) {
                termin++;
                counter = 0;
                System.out.println("termin " + termin);
            }
            System.out.println(queueTest.dequeue());
            counter++;
        }
        ArrayQueue<String> tempBoth = new ArrayQueue<>(100);
        while (!queueBoth.isEmpty()) {
            if(counter == capacity) {
                termin++;
                counter = 0;
                System.out.println(termin);
            }
            String s = queueBoth.dequeue();
            System.out.println(s);
            tempBoth.enqueue(s);
            counter++;
        }
        System.out.println("Polagaat zadaci:");
        termin = 1;
        counter = 0;
        System.out.println("termin " + termin);
        while (!queueExercises.isEmpty()) {
            if(counter == capacity) {
                termin++;
                counter = 0;
                System.out.println("termin " + termin);
            }
            System.out.println(queueExercises.dequeue());
            counter++;
        }
        while (!tempBoth.isEmpty()) {
            if(counter == capacity) {
                termin++;
                counter = 0;
                System.out.println(termin);
            }
            System.out.println(tempBoth.dequeue());
            counter++;
        }
    }
}
