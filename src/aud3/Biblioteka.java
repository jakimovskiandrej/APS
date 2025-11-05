package aud3;

import java.util.Scanner;

public class Biblioteka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueMagazine = new ArrayQueue<>(100);
        for(int i = 0; i < N; i++) {
            queueMagazine.enqueue(sc.nextLine());
        }
        int M = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueBooks = new ArrayQueue<>(100);
        for(int i = 0; i < M; i++) {
            queueBooks.enqueue(sc.nextLine());
        }
        int K = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueBoth = new ArrayQueue<>(100);
        for(int i = 0; i < K; i++) {
            queueBoth.enqueue(sc.nextLine());
        }
        boolean flag = true;
        while(!queueMagazine.isEmpty() || !queueBooks.isEmpty() || !queueBoth.isEmpty()) {
            if(flag) {
                if (!queueMagazine.isEmpty()) {
                    System.out.println(queueMagazine.dequeue());
                } else if (!queueBoth.isEmpty()) {
                    String student = queueBoth.dequeue();
                    System.out.println(student);
                    queueBooks.enqueue(student);
                }
            } else {
                if (!queueBooks.isEmpty()) {
                    System.out.println(queueBooks.dequeue());
                } else if (!queueBoth.isEmpty()) {
                    String student = queueBoth.dequeue();
                    System.out.println(student);
                    queueMagazine.enqueue(student);
                }
            }
            flag = !flag;
        }
    }
}
