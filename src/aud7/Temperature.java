//package aud7;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Objects;
//
//class Town {
//
//    String name;
//    String startInterval;
//    String endInterval;
//    double celsius;
//
//    public Town(String name,String startInterval, String endInterval, double celsius) {
//        this.name = name;
//        this.startInterval = startInterval;
//        this.endInterval = endInterval;
//        this.celsius = celsius;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getStartInterval() {
//        return startInterval;
//    }
//
//    public String getEndInterval() {
//        return endInterval;
//    }
//
//    public double getCelsius() {
//        return celsius;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setStartInterval(String startInterval) {
//        this.startInterval = startInterval;
//    }
//
//    public void setEndInterval(String endInterval) {
//        this.endInterval = endInterval;
//    }
//
//    public void setCelsius(double celsius) {
//        this.celsius = celsius;
//    }
//
//}
//
//public class Temperature {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        CBHT<String, ArrayList<Town>> table = new CBHT<>(1000);
//        for(int i=1;i<=N;i++) {
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//            Town town = new Town(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
//            if(table.search(parts[0]) == null) {
//                ArrayList<Town> towns = new ArrayList<>();
//                towns.add(town);
//                table.insert(parts[0], towns);
//            } else {
//                SLLNode<MapEntry<String,ArrayList<Town>>> current = table.search(parts[0]);
//                ArrayList<Town> list = current.element.value;
//                list.add(town);
//                table.insert(parts[0], list);
//            }
//        }
//        String line = br.readLine();
//        SLLNode<MapEntry<String,ArrayList<Town>>> current = table.search(line);
//        if(current == null) {
//            System.out.println("No data respectively");
//        } else {
//            Town maxTown = current.element.value.get(0);
//            for (Town town : current.element.value) {
//                if(town.celsius > maxTown.celsius) {
//                    maxTown = town;
//                }
//            }
//            System.out.printf("%s: %s - %s %.2f%n", maxTown.getName(),maxTown.getStartInterval(),maxTown.getEndInterval(),maxTown.getCelsius());
//        }
//    }
//}
