package aud7;

import java.util.Objects;
import java.util.Scanner;

class Vraboten implements Comparable<Vraboten>{
    String name;
    int age;

    public Vraboten(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vraboten vraboten = (Vraboten) o;
        return age == vraboten.age && Objects.equals(name, vraboten.name);
    }

    @Override
    public String toString() {
        return String.format("<%s, %d>", name, age);
    }

    @Override
    public int hashCode() {
        return name.charAt(0) * age;
    }

    @Override
    public int compareTo(Vraboten o) {
        return 0;
    }
}

class Proekt {
    int workingHours;
    int salaryByHour;

    public Proekt(int workingHours, int salaryByHour) {
        this.workingHours = workingHours;
        this.salaryByHour = salaryByHour;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getSalaryByHour() {
        return salaryByHour;
    }

    public void setSalaryByHour(int salaryByHour) {
        this.salaryByHour = salaryByHour;
    }

    public int totalSalary() {
        return workingHours * salaryByHour;
    }

    @Override
    public String toString() {
        return String.format("<%d, %d>", workingHours, salaryByHour);
    }
}

public class Courses1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        CBHT<Vraboten,Proekt> table = new CBHT<>(10);
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = sc.next();
            int age = sc.nextInt();
            int workingHours = sc.nextInt();
            int salaryByHour = sc.nextInt();
            Proekt proekt = new Proekt(workingHours, salaryByHour);
            Vraboten vraboten = new Vraboten(name, age);
            table.insert(vraboten, proekt);
            SLLNode<MapEntry<Vraboten,Proekt>> current = table.search(vraboten);
            if(current == null) {
                table.insert(vraboten, proekt);
            } else {
                Proekt prevProekt = current.element.value;
                if(prevProekt.totalSalary() >= proekt.totalSalary()) {
                    table.insert(vraboten, prevProekt);
                } else {
                    table.insert(vraboten, proekt);
                }
            }
        }
        System.out.println(table);
    }
}
