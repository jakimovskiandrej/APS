package aud3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Student {
    String name;
    char type;

    public Student(String name, char type) {
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

    @Override
    public String toString() {
        return name;
    }
}

public class Konsultacii {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<String> events = new LinkedList<>();
        Queue<Student> aps = new LinkedList<>();
        Queue<String> mms = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            String[] parts = br.readLine().split("\\s+");
            String name = parts[0];
            char type = parts[1].charAt(0);
            Student s = new Student(name, type);
            aps.add(s);
        }
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            mms.add(br.readLine());
        }
        while(!aps.isEmpty()) {
            Student s = aps.poll();
            char question = s.type;
            events.add(s.toString());
            if(!aps.isEmpty() && question == aps.peek().type) {
                if(!mms.isEmpty()) {
                    events.add(mms.poll());
                } else {
                    aps.add(aps.poll());
                }
            }
        }
        while(!mms.isEmpty()) {
            events.add(mms.poll());
        }
        for (String event : events) {
            System.out.println(event);
        }
    }
}
