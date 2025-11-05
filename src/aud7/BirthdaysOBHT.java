package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

class Employee implements Comparable<Employee> {
    String name;
    String surname;
    String date;

    public Employee(String name, String surname, String date) {
        this.name = name;
        this.surname = surname;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name,date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(date, employee.date);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(surname);
        result = 31 * result + Objects.hashCode(date);
        return result;
    }

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.name);
    }
}

public class BirthdaysOBHT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        OBHT<String, ArrayList<Employee>> table = new OBHT<String,ArrayList<Employee>>(2*N);
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            Employee employee = new Employee(parts[0], parts[1], parts[2]);
            String key = parts[2].substring(0,5);
            if(table.search(key) != -1) {
                MapEntry<String,ArrayList<Employee>> current = table.getBucket(table.search(key));
                ArrayList<Employee> list = current.value;
                list.add(employee);
                table.insert(key, list);
            } else {
                ArrayList<Employee> list = new ArrayList<Employee>();
                list.add(employee);
                table.insert(key, list);
            }
        }
        String dateIn = br.readLine();
        String date = dateIn.substring(0,5);
        int yearIn = Integer.parseInt(dateIn.substring(6,10));
        if(table.search(dateIn) != -1) {
            MapEntry<String,ArrayList<Employee>> current = table.getBucket(table.search(date));
            ArrayList<Employee> list = current.value;
            Employee[] e = new Employee[list.size()];
            for(int i = 0; i < e.length; i++) {
                e[i] = list.get(i);
            }
            Arrays.sort(e);
            for(int i=0;i<e.length;i++) {
                int year = Integer.parseInt(e[i].getDate().substring(6,10));
                System.out.println(e[i].toString() + " " + (yearIn - year));
            }
        } else {
            System.out.println("Empty");
        }
    }
}
