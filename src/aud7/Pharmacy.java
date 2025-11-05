package aud7;

import java.util.*;
import java.io.*;

class Name implements Comparable<Name> {

    String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return (100*(100*((name).charAt(2)) + name.charAt(1)) + name.charAt(0));
    }

    @Override
    public int compareTo(Name o) {
        return this.name.compareTo(o.name);
    }
}

class Drug {

    String name;
    int posList;
    int price;
    int quantity;

    public Drug(String name, int posList, int price, int quantity) {
        this.name = name;
        this.posList = posList;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosList() {
        return posList;
    }

    public void setPosList(int posList) {
        this.posList = posList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drug drug = (Drug) o;
        return posList == drug.posList && price == drug.price && quantity == drug.quantity && Objects.equals(name, drug.name);
    }

    @Override
    public String toString() {
        if(posList==1) {
            return name + " " + "POS" + " " + price + " " + quantity;
        } else {
            return name + " " + "NEG" + " " + price + " " + quantity;
        }
    }
}

public class Pharmacy {

    public static void main(String[] args) throws IOException {

        CBHT<Name,Drug> table = new CBHT<Name,Drug>(656565);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            Drug drug = new Drug(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
            table.insert(new Name(parts[0].toUpperCase()),drug);
        }

        String order = br.readLine().toUpperCase();

        while (order.compareTo("END")!=0) {
            int quantity = Integer.parseInt(br.readLine());
            SLLNode<MapEntry<Name,Drug>> result = table.search(new Name(order));
            if(result==null) {
                System.out.println("No such drug");
                order = br.readLine().toUpperCase();
            } else if (result.element.value.getName().equals(order)) {
                System.out.println(result.element.value.toString());
                if(result.element.value.getQuantity() < quantity) {
                    System.out.println("No drugs available");
                } else {
                    int oldQuantity = result.element.value.getQuantity();
                    result.element.value.setQuantity(oldQuantity - quantity);
                    table.insert(new Name(order),result.element.value);
                    System.out.println("Order made");
                }
                order = br.readLine().toUpperCase();
            } else {
                order = br.readLine().toUpperCase();
            }
        }
    }

}
