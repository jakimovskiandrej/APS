package aud7;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Covek {
    //Ime Prezime budzhet ip_adresa vreme grad cena
    String name;
    String surname;
    int budget;
    String ipAddress;
    String time;
    String city;
    int price;

    public Covek(String name, String surname, int budget, String ipAddress, String time, String city, int price) {
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.ipAddress = ipAddress;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //Sara Dobreva with salary 2700 from address 10.73.60.29 who spent 2500


    @Override
    public String toString() {
        return String.format("%s %s with salary %d from address %s who spent %d", name, surname, budget, ipAddress, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Covek covek = (Covek) o;
        return budget == covek.budget && price == covek.price && Objects.equals(name, covek.name) && Objects.equals(surname, covek.surname) && Objects.equals(ipAddress, covek.ipAddress) && Objects.equals(time, covek.time) && Objects.equals(city, covek.city);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(surname);
        result = 31 * result + budget;
        result = 31 * result + Objects.hashCode(ipAddress);
        result = 31 * result + Objects.hashCode(time);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + price;
        return result;
    }
}

public class Courses2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        CBHT<String,Covek> table = new CBHT<>(100);
        CBHT<String,Integer> tabela = new CBHT<>(100);
        for(int i = 0; i < N; i++) {
            String name = sc.next();
            String surname = sc.next();
            int budget = sc.nextInt();
            String ipAddress = sc.next();
            String time = sc.next();
            String city = sc.next();
            int price = sc.nextInt();
            Covek c = new Covek(name, surname, budget, ipAddress, time, city, price);
            table.insert(name, c);
            SLLNode<MapEntry<String,Integer>> current = tabela.search(city);
            if(budget >= price) {
                if(current == null) {
                    tabela.insert(city,1);
                } else {
                    tabela.insert(city,current.element.value+1);
                }
            }
            SLLNode<MapEntry<String,Covek>> current2 = table.search(city);
            if(budget >= price) {
                if(current2 == null) {
                    table.insert(city,c);
                } else {
                    if(current2.element.value.price >= price) {
                        table.insert(city,current2.element.value);
                    } else {
                        table.insert(city,c);
                    }
                }
            }
        }
        int m = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String city = parts[5];
            SLLNode<MapEntry<String,Integer>> current = tabela.search(city);
            System.out.println(String.format("City: %s has the following number of customers", city));
            System.out.println(current.element.value);
            SLLNode<MapEntry<String,Covek>> current2 = table.search(city);
            System.out.println(String.format("The user who spent the most purchasing for that city is:"));
            System.out.println(current2.element.value);
        }
    }
}
