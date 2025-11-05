package aud7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//Golf@Volkswagen@8000
class Car implements Comparable<Car> {
    String name;
    String model;
    double price;

    public Car(String name, String model, double price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Car o) {
        return Double.compare(this.price, o.price);
    }
}

public class Cars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        CBHT<String,List<Car>> map = new CBHT<String, List<Car>>(2*N-1);
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split("@");
            String name = parts[0];
            String model = parts[1];
            double price = Double.parseDouble(parts[2]);
            Car car = new Car(name,model,price);
            SLLNode<MapEntry<String,List<Car>>> current = map.search(model);
            if(current == null) {
                List<Car> cars = new ArrayList<>();
                cars.add(car);
                map.insert(model,cars);
            } else {
                List<Car> cars = map.search(model).element.value;
                cars.add(car);
                cars.sort(Comparator.comparingDouble(Car::getPrice));
                map.insert(model,cars);
            }
        }
        String carToSearch = sc.nextLine();
        SLLNode<MapEntry<String,List<Car>>> current = map.search(carToSearch);
        if(carToSearch == null) {
            System.out.println("Invalid result");
        } else {
            Car maxCar = current.element.value.getFirst();
            for (Car car : current.element.value) {
                if(car.getPrice() > maxCar.getPrice()) {
                    maxCar = car;
                }
            }
            System.out.println(maxCar.getName());
        }
    }
}
