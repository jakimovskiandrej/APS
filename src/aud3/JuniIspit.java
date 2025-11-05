package aud3;

import Ispitni.Array;

import java.util.Scanner;

public class JuniIspit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        sc.nextLine();
        ArrayQueue<Character> queue = new ArrayQueue<>(N);
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            if(line.startsWith("TYPE")) {
                char c = line.substring(5).charAt(0);
                queue.enqueue(c);
            }
            if(line.startsWith("UNDO")) {
                if(!queue.isEmpty()) {
                    queue.dequeue();
                }
            }
            if(line.startsWith("SHOW")) {
                while(!queue.isEmpty()) {
                    System.out.print(queue.dequeue());
                }
            }
        }
    }
}
