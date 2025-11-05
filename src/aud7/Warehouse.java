package aud7;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Medicine {
    String name;
    String type;
    int price;

    public Medicine(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;
        return price == medicine.price && Objects.equals(name, medicine.name) && Objects.equals(type, medicine.type);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + price;
        return result;
    }
}

public class Warehouse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        CBHT<String, ArrayList<Medicine>> table = new CBHT<>(2*N);
        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split("@");
            String name = parts[0];
            String type = parts[1];
            int price = Integer.parseInt(parts[2]);
            Medicine m = new Medicine(name,type,price);
            if(table.search(type) == null) {
                ArrayList<Medicine> medicines = new ArrayList<>();
                medicines.add(m);
                table.insert(type,medicines);
            } else {
                SLLNode<MapEntry<String,ArrayList<Medicine>>> current = table.search(type);
                ArrayList<Medicine> medicines = current.element.value;
                medicines.add(m);
                table.insert(type,medicines);
            }
        }
        String medicineToSearch = sc.nextLine();
        SLLNode<MapEntry<String,ArrayList<Medicine>>> current = table.search(medicineToSearch);
        if(current == null) {
            System.out.println("No medicine found");
        } else {
            Medicine minMedicine = current.element.value.getFirst();
            for (Medicine medicine : current.element.value) {
                if(medicine.getPrice() < minMedicine.getPrice()) {
                    minMedicine = medicine;
                }
            }
            System.out.println(minMedicine.getName());
        }
    }
}
