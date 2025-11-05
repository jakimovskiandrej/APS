package aud3;

import java.util.Objects;

public class EqualQueues {

    public static boolean equalQueues(ArrayQueue<Integer> queue1, ArrayQueue<Integer> queue2) {
        if(queue1.size() != queue2.size()) return false;
        int size = queue1.size();
        boolean flag = true;
        for(int i = 0; i < size; i++) {
            Integer e1 = queue1.peek();
            Integer e2 = queue2.peek();
            if(!Objects.equals(e1, e2)) {
                flag = false;
            }
            queue1.enqueue(e1);
            queue2.enqueue(e2);
        }
        return flag;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue1 = new ArrayQueue<>(100);
        ArrayQueue<Integer> queue2 = new ArrayQueue<>(100);

        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.enqueue(30);
        queue1.enqueue(40);
        queue2.enqueue(10);
        queue2.enqueue(20);
        queue2.enqueue(30);
        queue2.enqueue(40);

        System.out.println(equalQueues(queue1,queue2));
    }
}
