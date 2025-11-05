package aud3;

public class RotationQueue {

    public static void rotate(ArrayQueue<Integer> queue, int k) {
        for(int i = 0; i < k; i++) {
            int temp = queue.dequeue();
            queue.enqueue(temp);
        }
    }
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(100);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        rotate(queue,1);
        while(!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
