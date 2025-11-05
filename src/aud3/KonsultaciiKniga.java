package aud3;

import java.util.ArrayList;
import java.util.Scanner;

class Studentot {
    String name;
    char type;

    public Studentot(String name, char type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}

public class KonsultaciiKniga {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayQueue<Studentot> queueAPS = new ArrayQueue<>(100);
        ArrayList<String> events = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String name = parts[0];
            char type = parts[1].charAt(0);
            Studentot s = new Studentot(name, type);
            queueAPS.enqueue(s);
        }
        ArrayQueue<String> queueMMS = new ArrayQueue<>(100);
        int M = Integer.parseInt(sc.nextLine());
        for(int i=0; i<M; i++) {
            queueMMS.enqueue(sc.nextLine());
        }
        while(!queueAPS.isEmpty()) {
            Studentot s = queueAPS.dequeue();
            char type = s.getType();
            events.add(s.getName());
            if(!queueAPS.isEmpty() && queueAPS.peek().getType() == type) {
                if(!queueMMS.isEmpty()) {
                    events.add(queueMMS.dequeue());
                }
                queueAPS.enqueue(queueAPS.dequeue());
            }
        }
        while(!queueMMS.isEmpty()) {
            events.add(queueMMS.dequeue());
        }
        for (String event : events) {
            System.out.println(event);
        }
    }
}
