package aud3;

import java.util.ArrayList;
import java.util.Scanner;

public class Consultations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayQueue<String> queueQuestions = new ArrayQueue<>(100);
        ArrayQueue<String> queueExercises = new ArrayQueue<>(100);
        ArrayQueue<String> queueQuestionsExercises = new ArrayQueue<>(100);
        for(int i = 0; i < N; i++) {
            queueQuestions.enqueue(sc.nextLine().trim());
        }
        int M = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < M; i++) {
            queueExercises.enqueue(sc.nextLine().trim());
        }
        int K = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < K; i++) {
            queueQuestionsExercises.enqueue(sc.nextLine().trim());
        }
        ArrayList<String> list = new ArrayList<>();
        while(!queueQuestions.isEmpty() || !queueExercises.isEmpty() || !queueQuestionsExercises.isEmpty()) {
            if(!queueQuestions.isEmpty()) {
                list.add(queueQuestions.dequeue());
            } else if(!queueQuestionsExercises.isEmpty()) {
                String student = queueQuestionsExercises.dequeue();
                list.add(student);
                queueExercises.enqueue(student);
            }
            if(!queueExercises.isEmpty()) {
                list.add(queueExercises.dequeue());
            } else if(!queueQuestionsExercises.isEmpty()) {
                String student = queueQuestionsExercises.dequeue();
                list.add(student);
                queueQuestions.enqueue(student);
            }
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
