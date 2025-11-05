package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Driver implements Comparable<Driver> {

    String name;
    String surname;
    Date time;

    public Driver(String name, String surname, Date time) {
        this.name = name;
        this.surname = surname;
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int compareTo(Driver o) {
        return time.compareTo(o.time);
    }
}

public class TrafficLights {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        OBHT<String,String> table = new OBHT<>(2*N);
        for(int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            table.insert(parts[0], parts[1]);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        int speed = Integer.parseInt(br.readLine());
        String[] traffic = br.readLine().split(" ");
        LinkedList<Driver> drivers = new LinkedList<>();
        for(int i=0;i<(traffic.length-2);i+=3) {
            String plateDriver = traffic[i];
            int speedDriver = Integer.parseInt(traffic[i+1]);
            String timeDriver = traffic[i+2];
//            if(speedDriver > speed) {
//                String[] parts = table.getBucket(table.search((plateDriver))).value.split(" ");
//                drivers.add(new Driver(parts[0],parts[1],sdf.parse(timeDriver)));
//            }
        }
        Collections.sort(drivers);
        for (Driver driver : drivers) {
            System.out.println(driver.toString());
        }
    }

}
