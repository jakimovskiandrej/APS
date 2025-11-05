package aud3;

public class CountOccurrences {

    public static int countOccurrences(ArrayQueue<Integer> queue, int target) {
        int counter = 0;
        for(int i=0;i<queue.size();i++) {
            int current = queue.dequeue();
            if(current == target) {
                counter++;
            }
            queue.enqueue(current);
        }
        return counter;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(100);

        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(3);
        queue.enqueue(3);
        queue.enqueue(2);

        int target = 3;
        int result = countOccurrences(queue, target);
        System.out.println("Елементот " + target + " се појавува " + result + " пати.");

        System.out.print("Редицата: \n");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + "\n");
        }
    }
}
