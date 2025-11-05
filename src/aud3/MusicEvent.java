package aud3;
//Со карта за VIP зона
//
//Со карта за стандардна зона
//
//Со комбинирана карта (важи и за двете)
//Прво се пушта еден во VIP (ако нема, комбиниран оди таму, па се прардеместува во редица за станд).
//
//Потоа се пушта еден во стандард (ако нема, комбиниран оди таму, па се преместува во редица за VIP).
//
//Се повторува додека има посетители.

import java.util.Scanner;

public class MusicEvent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueVIP = new ArrayQueue<>(100);
        for(int i = 0; i < N; i++) {
            queueVIP.enqueue(sc.nextLine());
        }
        int M = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueStandard = new ArrayQueue<>(100);
        for(int i = 0; i < M; i++) {
            queueStandard.enqueue(sc.nextLine());
        }
        int K = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueBoth = new ArrayQueue<>(100);
        for(int i = 0; i < K; i++) {
            queueBoth.enqueue(sc.nextLine());
        }
        boolean flag = true;
        while (!queueVIP.isEmpty() || !queueStandard.isEmpty() || !queueBoth.isEmpty()) {
            if (flag) {
                if (!queueVIP.isEmpty()) {
                    System.out.println(queueVIP.dequeue());
                } else if (!queueBoth.isEmpty()) {
                    String s = queueBoth.dequeue();
                    System.out.println(s);
                    queueStandard.enqueue(s);
                }
            } else {
                if (!queueStandard.isEmpty()) {
                    System.out.println(queueStandard.dequeue());
                } else if (!queueBoth.isEmpty()) {
                    String s = queueBoth.dequeue();
                    System.out.println(s);
                    queueVIP.enqueue(s);
                }
            }
            flag = !flag;
        }
    }
}
