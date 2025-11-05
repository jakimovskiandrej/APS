package aud3;

import Ispitni.Array;

import java.util.Arrays;
import java.util.*;
import java.util.Queue;
import java.util.Scanner;

public class Kolokvium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = Integer.parseInt(sc.nextLine());
        int n1 = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> prijaveniMatematika = new ArrayQueue<>(100);
        for (int i = 0; i < n1; i++) {
            prijaveniMatematika.enqueue(sc.nextLine());
        }
        int n2 = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> prijaveniBiloKoj = new ArrayQueue<>(100);
        for (int i = 0; i < n2; i++) {
            prijaveniBiloKoj.enqueue(sc.nextLine());
        }
        int n3 = Integer.parseInt(sc.nextLine());
        LinkedList<String> listRealMath = new LinkedList<>();
        for (int i = 0; i < n3; i++) {
            listRealMath.add(sc.nextLine());
        }
        ArrayQueue<String> validMath = new ArrayQueue<>(100);
        ArrayQueue<String> cheaters = new ArrayQueue<>(100);
        while (!prijaveniMatematika.isEmpty()) {
            String student = prijaveniMatematika.dequeue();
            if (listRealMath.contains(student)) {
                validMath.enqueue(student);
            } else {
                cheaters.enqueue(student);
            }
        }
        ArrayQueue<String> result = new ArrayQueue<>(100);
        while (!validMath.isEmpty()) {
            result.enqueue(validMath.dequeue());
        }
        while (!prijaveniBiloKoj.isEmpty()) {
            result.enqueue(prijaveniBiloKoj.dequeue());
        }
        while (!cheaters.isEmpty()) {
            result.enqueue(cheaters.dequeue());
        }

        int term = 1;
        while (!result.isEmpty()) {
            System.out.println(term);
            for (int i = 0; i < capacity && !result.isEmpty(); i++) {
                System.out.println(result.dequeue());
            }
            term++;
        }
    }
}
