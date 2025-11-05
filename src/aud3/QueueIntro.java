package aud3;

import aud1.SLL;

import java.util.LinkedList;


public class QueueIntro {



    public static void main(String[] args) {
        ArrayQueue<Integer> q = new ArrayQueue<Integer>(100);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.enqueue(70);
        q.enqueue(80);
        q.enqueue(90);
        q.enqueue(100);

        while(!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
    }
}
