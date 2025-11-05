package aud3;

public class PriorityQueueIntro {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.enqueue(100);
        priorityQueue.enqueue(200);
        priorityQueue.enqueue(300);
        priorityQueue.enqueue(400);
        SLLNode<Integer> fixRear = priorityQueue.front;
        while(fixRear != null && fixRear.succ != null) {
            fixRear = fixRear.succ;
        }
        priorityQueue.rear = fixRear;
        SLLNode<Integer> current = priorityQueue.front;
        while(current != null) {
            System.out.println(current.element);
            current = current.succ;
        }
    }
}
