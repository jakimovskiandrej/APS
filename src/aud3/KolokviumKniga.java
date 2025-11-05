package aud3;

import java.util.Scanner;

public class KolokviumKniga {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueWhenever = new ArrayQueue<>(100);
        for(int i = 0; i < N; i++) {
            queueWhenever.enqueue(sc.nextLine());
        }
        int M = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueMath = new ArrayQueue<>(100);
        for(int i = 0; i < M; i++) {
            queueMath.enqueue(sc.nextLine());
        }
        int counter = 0;
        while(!queueWhenever.isEmpty()) {

        }
    }
}
