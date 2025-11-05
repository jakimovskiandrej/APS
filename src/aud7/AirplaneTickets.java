package aud7;

import java.util.*;

class Ticket implements Comparable<Ticket> {
    String townFrom;
    String townTo;
    String time;
    double price;

    public Ticket(String townFrom, String townTo, String time, double price) {
        this.townFrom = townFrom;
        this.townTo = townTo;
        this.time = time;
        this.price = price;
    }

    public String getTownFrom() {
        return townFrom;
    }

    public void setTownFrom(String townFrom) {
        this.townFrom = townFrom;
    }

    public String getTownTo() {
        return townTo;
    }

    public void setTownTo(String townTo) {
        this.townTo = townTo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s %s %.2f\n", townFrom, townTo, time, price);
    }

    @Override
    public int compareTo(Ticket o) {
        return this.time.compareTo(o.time);
    }
}

public class AirplaneTickets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        CBHT<String,ArrayList<Ticket>> map = new CBHT<String,ArrayList<Ticket>>(2*N-1);
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String townFrom = parts[0];
            String townTo = parts[1];
            String time = parts[2];
            double price = Double.parseDouble(parts[3]);
            Ticket ticket = new Ticket(townFrom, townTo, time, price);
            SLLNode<MapEntry<String,ArrayList<Ticket>>> current = map.search(townFrom);
            if(current == null) {
                ArrayList<Ticket> tickets = new ArrayList<>();
                tickets.add(ticket);
                map.insert(townFrom, tickets);
            } else {
                ArrayList<Ticket> tickets = map.search(townFrom).element.value;
                tickets.add(ticket);
                tickets.sort(Comparator.comparing(Ticket::getTime));
                map.insert(townFrom, tickets);
            }
        }
        String townToSearch = sc.nextLine();
        SLLNode<MapEntry<String,ArrayList<Ticket>>> current = map.search(townToSearch);
        if(current == null) {
            System.out.println("Невалиден град");
        } else {
            System.out.printf("%s:%n",townToSearch);
            for (Ticket t : current.element.value) {
                System.out.println(t.toString());
            }
        }
    }
}
