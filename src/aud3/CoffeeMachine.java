package aud3;

import Ispitni.Array;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueEspresso = new ArrayQueue<>(100);
        for(int i = 0; i < N; i++) {
            queueEspresso.enqueue(sc.nextLine());
        }
        int M = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueCappuccino = new ArrayQueue<>(100);
        for(int i = 0; i < M; i++) {
            queueCappuccino.enqueue(sc.nextLine());
        }
        int K = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueCombination = new ArrayQueue<>(100);
        for(int i = 0; i < K; i++) {
            queueCombination.enqueue(sc.nextLine());
        }
        boolean turnEspresso = true;
        while(!queueEspresso.isEmpty() || !queueCappuccino.isEmpty() || !queueCombination.isEmpty()) {
            if(turnEspresso) {
                if(!queueEspresso.isEmpty()) {
                    System.out.println(queueEspresso.dequeue());
                } else if (!queueCombination.isEmpty()){
                    System.out.println(queueCombination.dequeue());
                    queueCappuccino.enqueue(queueCombination.dequeue());
                }
            } else {
                if(!queueCappuccino.isEmpty()) {
                    System.out.println(queueCappuccino.dequeue());
                } else if (!queueCombination.isEmpty()) {
                    System.out.println(queueCombination.dequeue());
                    queueEspresso.enqueue(queueCombination.dequeue());
                }
            }
            turnEspresso = !turnEspresso;
        }
    }
}
