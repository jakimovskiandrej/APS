package aud7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

class Lecture implements Comparable<Lecture> {
    String date;
    String time;
    String city;
    int price;

    public Lecture(String date, String time, String city, int price) {
        this.date = date;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getCity() {
        return city;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Lecture o) {
        return Integer.compare(getPrice(), o.getPrice());
    }
}

public class BestOffer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String,ArrayList<Lecture>> table = new CBHT<>(2*N);
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            String date = line.split(" ")[0];
            String time = line.split(" ")[1];
            String city = line.split(" ")[2];
            int price = Integer.parseInt(line.split(" ")[3]);
            Lecture lecture = new Lecture(date, time, city, price);
            if(table.search(date) == null) {
                ArrayList<Lecture> lectures = new ArrayList<>();
                lectures.add(lecture);
                table.insert(date, lectures);
            } else {
                SLLNode<MapEntry<String,ArrayList<Lecture>>> current = table.search(date);
                ArrayList<Lecture> lectures = current.element.value;
                lectures.add(lecture);
                lectures.sort(Comparator.reverseOrder());
                table.insert(date, lectures);
            }
        }
        String date = br.readLine();
        SLLNode<MapEntry<String,ArrayList<Lecture>>> result = table.search(date);
        if(result == null) {
            System.out.println("No offers");
        } else {
            System.out.printf("%s %s %d%n",result.element.value.getFirst().getTime(),result.element.value.getFirst().getCity(),result.element.value.getFirst().getPrice());
        }
    }
}
