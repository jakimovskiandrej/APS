package aud3;

import java.util.ArrayList;

public class MaxElement {

    public static int findMax(ArrayQueue<Integer> queue) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < queue.size(); i++) {
            int current = queue.dequeue();
            if(current > max) {
                max = current;
            }
            queue.enqueue(current);
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(100);

        queue.enqueue(12);
        queue.enqueue(4);
        queue.enqueue(19);
        queue.enqueue(7);
        queue.enqueue(15);

        System.out.print("Редицата: ");
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int val = queue.dequeue();
            System.out.print(val + " ");
            queue.enqueue(val);
        }
        System.out.println();

        int max = findMax(queue);
        System.out.println("Најголемиот елемент е: " + max);
    }
}
