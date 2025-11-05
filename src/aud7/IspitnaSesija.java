package aud7;

import java.util.*;

class Course implements Comparable<Course> {
    String date;
    String time;
    String room;
    String subject;

    public Course(String date, String time, String room, String subject) {
        this.date = date;
        this.time = time;
        this.room = room;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    @Override
    public int compareTo(Course o) {
        return this.time.compareTo(o.time);
    }
}

public class IspitnaSesija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        OBHT<String, ArrayList<Course>> table = new OBHT<>(2*N);
        ArrayList<Course> courses = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String date = parts[0];
            String time = parts[1];
            String room = parts[2];
            String subject = parts[3];
            courses.add(new Course(date, time, room, subject));
            table.insert(date, new ArrayList<Course>());
        }
        String dateToSearch = sc.nextLine();
        ArrayList<Course> filtered = new ArrayList<>();
        for (Course course : courses) {
            if(course.getDate().equals(dateToSearch)) {
                filtered.add(course);
            }
        }
        Collections.sort(filtered);
        for (Course course : filtered) {
            System.out.printf("%s %s %s%n", course.getTime(), course.getRoom(), course.getSubject());
        }
    }
}
