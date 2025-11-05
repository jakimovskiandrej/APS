package aud3;

import java.util.*;
import java.io.*;

public class ColloquiumWeek {

    public static boolean isMissing(String name, ArrayQueue<String> missing) {
        ArrayQueue<String> temp = new ArrayQueue<>(100);
        boolean found = false;
        while (!missing.isEmpty()) {
            String m = missing.dequeue();
            if(m.equals(name)) {
                found = true;
            }
            temp.enqueue(m);
        }
        while(!temp.isEmpty()) {
            missing.enqueue(temp.dequeue());
        }
        return found;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String assistants = "";
        ArrayQueue<String> queue = new ArrayQueue<>(100);
        ArrayQueue<String> missingQueue = new ArrayQueue<>(100);
        for(int i = 0; i < N; i++) {
            assistants = sc.nextLine();
            queue.enqueue(assistants);
        }
        int M = Integer.parseInt(sc.nextLine());
        String[] subjects = new String[M];
        int[] assistantsNeeded = new int[M];
        for(int i = 0; i < M; i++) {
            String[] parts = sc.nextLine().split(" ");
            subjects[i] = parts[0];
            assistantsNeeded[i] = Integer.parseInt(parts[1]);
        }
        int K = Integer.parseInt(sc.nextLine());
        String assistantsMissing;
        for(int i = 0; i < K; i++) {
            assistantsMissing = sc.nextLine();
            missingQueue.enqueue(assistantsMissing);
        }
        for(int i = 0; i < M; i++) {
            String subject = subjects[i];
            int needed = assistantsNeeded[i];
            System.out.printf("%s\n%d\n", subject, needed);
            int assigned = 0;
            ArrayQueue<String> temp = new ArrayQueue<>(100);
            while (assigned < needed) {
                String assistaint = missingQueue.dequeue();
                if(!isMissing(assistaint,missingQueue)) {
                    temp.enqueue(assistaint);
                    assigned++;
                }
            }
            while(!queue.isEmpty()) {
                temp.enqueue(queue.dequeue());
            }
            while(!temp.isEmpty()) {
                queue.enqueue(temp.dequeue());
            }
        }

    }
}
