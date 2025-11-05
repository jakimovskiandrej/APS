package aud3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class ConsultationsBackAndForth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<String> questions = new LinkedList<String>();
        Queue<String> problems = new LinkedList<String>();
        Queue<String> both = new LinkedList<String>();
        for (int i = 0; i < n; i++) {
            questions.add(br.readLine().trim());
        }
        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            problems.add(br.readLine());
        }
        int k = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < k; i++) {
            both.add(br.readLine());
        }
        LinkedList<String> events = new LinkedList<>();
        while (!both.isEmpty() || !questions.isEmpty() || !problems.isEmpty()) {
            if(!questions.isEmpty()) {
                events.add(questions.poll());
            } else if(!both.isEmpty()) {
                String student = both.poll();
                events.add(student);
                problems.add(student);
            }
            if(!problems.isEmpty()) {
                events.add(problems.poll());
            } else if(!both.isEmpty()) {
                String student = both.poll();
                events.add(student);
                questions.add(student);
            }
        }
        for (String event : events) {
            System.out.println(event);
        }
    }
}
