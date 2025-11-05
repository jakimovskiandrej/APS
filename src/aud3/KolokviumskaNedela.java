package aud3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Subject {
    String name;
    int assistantsNeeded;

    public Subject(String name, int assistantsNeeded) {
        this.name = name;
        this.assistantsNeeded = assistantsNeeded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAssistantsNeeded() {
        return assistantsNeeded;
    }

    public void setAssistantsNeeded(int assistantsNeeded) {
        this.assistantsNeeded = assistantsNeeded;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class KolokviumskaNedela {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Subject> subjects = new ArrayList<>();
        ArrayList<String> absent = new ArrayList<>();
        ArrayList<String> input = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            input.add(br.readLine());
        }
        int m = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < m; i++) {
            String line = br.readLine().trim();
            String[] parts = line.split("\\s+");
            String subject = parts[0];
            int assistantsNeeded = Integer.parseInt(parts[1]);
            Subject s = new Subject(subject, assistantsNeeded);
            subjects.add(s);
        }
        int k = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < k; i++) {
            absent.add(br.readLine());
        }
        Queue<String> assistants = new LinkedList<>();
        for(int i=0;i<input.size();i++) {
            String assistant = input.get(i);
            if(!absent.contains(assistant)) {
                assistants.offer(assistant);
            }
        }
        for(int i = 0; i < subjects.size(); i++) {
            Subject subject = subjects.get(i);
            System.out.println(subject);
            System.out.println(subject.assistantsNeeded);
            for(int j = 0; j < subject.assistantsNeeded; j++) {
                String assistant = assistants.poll();
                System.out.println(assistant);
                assistants.offer(assistant);
            }
        }
    }
}
