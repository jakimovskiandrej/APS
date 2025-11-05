package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Session {

    String date;
    String time;
    String room;
    String course;

    public Session(String date, String time, String room, String course) {
        this.date = date;
        this.time = time;
        this.room = room;
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return time + " " + room + " " + course;
    }
}

public class ExamSession {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        OBHT<String,ArrayList<Session>> table = new OBHT<>(2*N);
        for(int i=0;i<N;i++) {
            String[] parts = br.readLine().split(" ");
            String date = parts[0];
            String time = parts[1];
            String room = parts[2];
            String course = parts[3];
            String key = date;
            Session session = new Session(date, time, room, course);
            if(table.search(key) == -1) {
                ArrayList<Session> list = new ArrayList<Session>();
                list.add(session);
                table.insert(key,list);
            } else {
                ArrayList<Session> list = new ArrayList<>();
                list.add(session);
            }
        }
        String targetDate = br.readLine();
        int index = table.search(targetDate);
        if(index != -1) {
            
        }
    }
}
