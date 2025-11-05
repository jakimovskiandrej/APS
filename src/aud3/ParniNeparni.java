package aud3;

import java.util.Scanner;

public class ParniNeparni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayQueue<Integer> queue = new ArrayQueue<>(100);
        for (int i = 0; i < N; i++) {
            queue.enqueue(sc.nextInt());
        }
        ArrayQueue<Integer> evenQueue = new ArrayQueue<>(100);
        ArrayQueue<Integer> oddQueue = new ArrayQueue<>(100);
        int sum = 0;
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            if (current % 2 == 0) {
                sum += current;
                evenQueue.enqueue(current);
            } else {
                oddQueue.enqueue(current);
            }
        }
        System.out.println("Sum numbers: \n");
        while (!evenQueue.isEmpty()) {
            System.out.println(evenQueue.dequeue() + "");
        }
        System.out.println("Sum of even numbers: " + sum);
    }
}
