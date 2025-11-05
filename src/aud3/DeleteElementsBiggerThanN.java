package aud3;

public class DeleteElementsBiggerThanN {

    public static void removeGreaterThan(ArrayQueue<Integer> queue, int n) {
        for(int i=0;i<queue.size();i++) {
            int current = queue.dequeue();
            if(current <= n) {
                queue.enqueue(current);
            }
        }
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(100);

        queue.enqueue(5);
        queue.enqueue(12);
        queue.enqueue(7);
        queue.enqueue(3);
        queue.enqueue(20);
        queue.enqueue(1);

        int n = 10;
        removeGreaterThan(queue, n);

        System.out.println("Редицата по бришење на елементи поголеми од " + n + ":");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
