package aud3;

import java.util.ArrayList;
import java.util.Scanner;

class Studenti {
    String name;
    int science;
    int scienceFiction;
    int history;

    public Studenti(String name, int science, int scienceFiction, int history) {
        this.name = name;
        this.science = science;
        this.scienceFiction = scienceFiction;
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public int getScience() {
        return science;
    }

    public int getScienceFiction() {
        return scienceFiction;
    }

    public int getHistory() {
        return history;
    }
}

public class Courses3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayQueue<Studenti> scienceQueue = new ArrayQueue<>(100);
        ArrayQueue<Studenti> scienceFictionQueue = new ArrayQueue<>(100);
        ArrayQueue<Studenti> historyQueue = new ArrayQueue<>(100);
        for(int i = 0; i < n; i++) {
           String name = sc.nextLine();
           int science = sc.nextInt();
           sc.nextLine();
           int scienceFiction = sc.nextInt();
           sc.nextLine();
           int history = sc.nextInt();
           sc.nextLine();
           Studenti student = new Studenti(name, science, scienceFiction, history);
           if(science == 1) {
               scienceQueue.enqueue(student);
           } else if(scienceFiction == 1) {
               scienceFictionQueue.enqueue(student);
           } else if(history == 1) {
               historyQueue.enqueue(student);
           }
        }
        while(!scienceQueue.isEmpty() || !scienceFictionQueue.isEmpty() || !historyQueue.isEmpty()) {
            int served = 0;
            while(served < 2 && !scienceQueue.isEmpty()) {
                Studenti student = scienceQueue.dequeue();
                student.science = 0;
                if(student.getScienceFiction() == 1) {
                    scienceFictionQueue.enqueue(student);
                } else if(student.getHistory() == 1) {
                    historyQueue.enqueue(student);
                } else {
                    System.out.println(student.getName());
                }
                served++;
            }
            if(!scienceFictionQueue.isEmpty()) {
                Studenti student = scienceFictionQueue.dequeue();
                student.scienceFiction = 0;
                if(student.getHistory() == 1) {
                    historyQueue.enqueue(student);
                } else {
                    System.out.println(student.getName());
                }
            }
            served = 0;
            while(served < 2 && !historyQueue.isEmpty()) {
                Studenti student = historyQueue.dequeue();
                student.history = 0;
                System.out.println(student.getName());
                served++;
            }
        }
    }
}
