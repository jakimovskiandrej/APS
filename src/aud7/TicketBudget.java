//package aud7;
//
//import java.util.*;
//
//class Person implements Comparable<Person> {
//    String name;
//    String surname;
//    int budget;
//    String ipAddress;
//    String time;
//    String city;
//    int price;
//
//    public Person(String name, String surname, int budget, String ipAddress, String time, String city, int price) {
//        this.name = name;
//        this.surname = surname;
//        this.budget = budget;
//        this.ipAddress = ipAddress;
//        this.time = time;
//        this.city = city;
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%s %s with salary %d from address %s who spent %d", name, surname, budget, ipAddress, price);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person person = (Person) o;
//        return budget == person.budget && price == person.price && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(ipAddress, person.ipAddress) && Objects.equals(time, person.time) && Objects.equals(city, person.city);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hashCode(name);
//        result = 31 * result + Objects.hashCode(surname);
//        result = 31 * result + budget;
//        result = 31 * result + Objects.hashCode(ipAddress);
//        result = 31 * result + Objects.hashCode(time);
//        result = 31 * result + Objects.hashCode(city);
//        result = 31 * result + price;
//        return result;
//    }
//
//    @Override
//    public int compareTo(Person o) {
//        return price > o.price ? 1 : 0;
//    }
//}
//
//public class TicketBudget {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        sc.nextLine();
//        CBHT<String,Integer> table1 = new CBHT<>(2*N-1);
//        CBHT<String,Person> table2 = new CBHT<>(2*N-1);
//        for(int i = 0; i < N; i++) {
//            String line = sc.nextLine();
//            String[] parts = line.split("\\s+");
//            String name = parts[0];
//            String surname = parts[1];
//            int budget = Integer.parseInt(parts[2]);
//            String ipAddress = parts[3];
//            String time = parts[4];
//            String city = parts[5];
//            int price = Integer.parseInt(parts[6]);
//
//            Person p = new Person(name, surname, budget, ipAddress, time, city, price);
//            String network = ipAddress.split("\\.")[0] + "." + ipAddress.split("\\.")[1] + "." + ipAddress.split("\\.")[2];
//            if(budget >= price) {
//                SLLNode<MapEntry<String,Integer>> current = table1.search(network);
//                if(current == null) {
//                    table1.insert(network,1);
//                } else {
//                    int prev = current.element.value;
//                    table1.insert(network,prev+1);
//                }
//            }
//            if(budget >= price) {
//                SLLNode<MapEntry<String,Person>> current2 = table2.search(network);
//                if(current2 == null) {
//                    table2.insert(network,p);
//                } else {
//                    Person max = current2.element.value;
//                    if(p.price > max.price) {
//                        table2.insert(network,p);
//                    }
//                }
//            }
//        }
//
//        int m = sc.nextInt();
//        sc.nextLine();
//        for(int i=0;i<m;i++) {
//            String[] parts = sc.nextLine().split("\\s+");
//            String ip = parts[3];
//            String network = ip.split("\\.")[0] + "." + ip.split("\\.")[1] + "." + ip.split("\\.")[2];
//            SLLNode<MapEntry<String,Integer>> current = table1.search(network);
//            System.out.println("IP network: " + network + " has the following number of users:");
//            System.out.println(current.element.value);
//            SLLNode<MapEntry<String,Person>> current2 = table2.search(network);
//            System.out.println("The user who spent the most from that network is:");
//            System.out.println(current2.element.value.toString() + "\n");
//        }
//    }
//}
