package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class City {
    String name;
    String startInterval;
    String endInterval;
    double celsius;

    public City(String name, String startInterval, String endInterval, double celsius) {
        this.name = name;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.celsius = celsius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartInterval() {
        return startInterval;
    }

    public void setStartInterval(String startInterval) {
        this.startInterval = startInterval;
    }

    public String getEndInterval() {
        return endInterval;
    }

    public void setEndInterval(String endInterval) {
        this.endInterval = endInterval;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

}

public class WeatherForecast {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        CBHT<String,ArrayList<City>> table = new CBHT<String,ArrayList<City>>(1000);
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String name = parts[0];
            String startInterval = parts[1];
            String endInterval = parts[2];
            double celsius = Double.parseDouble(parts[3]);
            City c = new City(name, startInterval, endInterval, celsius);
            if(table.search(name) == null) {
                ArrayList<City> cities = new ArrayList<>();
                cities.add(c);
                table.insert(name, cities);
            } else {
                SLLNode<MapEntry<String,ArrayList<City>>> current = table.search(name);
                ArrayList<City> cities = current.element.value;
                cities.add(c);
                table.insert(name,cities);
            }
        }
        String cityToSearch = sc.nextLine();
        SLLNode<MapEntry<String,ArrayList<City>>> current = table.search(cityToSearch);
        if(current == null) {
            System.out.printf("%s: does not exist%n", cityToSearch);
        } else {
            System.out.printf("%s%n", cityToSearch);
            for (City city : current.element.value) {
                System.out.printf("%s - %s %.2f%n", city.getStartInterval(), city.getEndInterval(), city.getCelsius());
            }
        }
    }
}
