package aud7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Grad implements Comparable<Grad>{
    String city;
    String startInterval;
    String endInterval;
    double temperature;

    public Grad(String city, String startInterval, String endInterval, double temperature) {
        this.city = city;
        this.startInterval = startInterval;
        this.endInterval = endInterval;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public String getStartInterval() {
        return startInterval;
    }

    public String getEndInterval() {
        return endInterval;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public int compareTo(Grad o) {
        return Double.compare(temperature, o.temperature);
    }
}

public class Temperatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        CBHT<String, ArrayList<Grad>> table = new CBHT<>(2*N);
        for(int i=0;i<N;i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String city = parts[0];
            String startInterval = parts[1];
            String endInterval = parts[2];
            double temperature = Double.parseDouble(parts[3]);
            Grad grad = new Grad(city, startInterval, endInterval, temperature);
            if(table.search(city) == null) {
                ArrayList<Grad> list = new ArrayList<>();
                list.add(grad);
                table.insert(city, list);
            } else {
                ArrayList<Grad> list = table.search(city).element.value;
                list.add(grad);
                list.sort(Comparator.comparing(Grad::getTemperature));
                table.insert(city, list);
            }
        }
        String cityToSearch = sc.nextLine();
        SLLNode<MapEntry<String,ArrayList<Grad>>> result = table.search(cityToSearch);
        if(result == null) {
            System.out.println("No data");
        } else {
            Grad maxGrad = result.element.value.getFirst();
            for (Grad grad : result.element.value) {
                if(grad.getTemperature() > maxGrad.getTemperature()) {
                    maxGrad = grad;
                }
            }
            System.out.println(String.format("%s: %s - %s %.1f", maxGrad.getCity(),maxGrad.getStartInterval(),maxGrad.getEndInterval(),maxGrad.getTemperature()));
        }
    }
}
