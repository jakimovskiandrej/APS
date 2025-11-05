package aud3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Sttudent {
    String name;
    int documents;
    int index;
    int highschoolDocuments;

    public Sttudent(String name, int documents, int index, int highschoolDocuments) {
        this.name = name;
        this.documents = documents;
        this.index = index;
        this.highschoolDocuments = highschoolDocuments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDocuments() {
        return documents;
    }

    public void setDocuments(int documents) {
        this.documents = documents;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getHighschoolDocuments() {
        return highschoolDocuments;
    }

    public void setHighschoolDocuments(int highschoolDocuments) {
        this.highschoolDocuments = highschoolDocuments;
    }
}

public class Courses5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayQueue<Sttudent> queueIndex = new ArrayQueue<>(100);
        ArrayQueue<Sttudent> queueDocuments = new ArrayQueue<>(100);
        ArrayQueue<Sttudent> queueHighschoolDocuments = new ArrayQueue<>(100);
        for(int i=0;i<N;i++) {
            String name = sc.nextLine();
            int documents = sc.nextInt();
            sc.nextLine();
            int index = sc.nextInt();
            sc.nextLine();
            int highschoolDocuments = sc.nextInt();
            sc.nextLine();
            Sttudent student = new Sttudent(name, documents, index, highschoolDocuments);
            if(documents == 1) {
                queueDocuments.enqueue(student);
            } else if(index == 1) {
                queueIndex.enqueue(student);
            } else if(highschoolDocuments == 1) {
                queueHighschoolDocuments.enqueue(student);
            }
        }
        while(!queueIndex.isEmpty() || !queueDocuments.isEmpty() || !queueHighschoolDocuments.isEmpty()) {
            int counter = 0;
            while(counter < 2 && !queueDocuments.isEmpty()) {
                Sttudent student = queueDocuments.dequeue();
                if(student.getIndex() == 1) {
                    queueIndex.enqueue(student);
                } else if(student.getHighschoolDocuments() == 1) {
                    queueHighschoolDocuments.enqueue(student);
                } else {
                    System.out.println(student.getName());
                }
                counter++;
            }
            counter = 0;
            while (counter < 3 && !queueIndex.isEmpty()) {
                Sttudent student = queueIndex.dequeue();
                if(student.getHighschoolDocuments() == 1) {
                    queueHighschoolDocuments.enqueue(student);
                } else {
                    System.out.println(student.getName());
                }
                counter++;
            }
            if(!queueHighschoolDocuments.isEmpty()) {
                Sttudent student = queueHighschoolDocuments.dequeue();
                System.out.println(student.getName());
            }
        }
    }
}
