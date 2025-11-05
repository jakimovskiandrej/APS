//package aud7;
//import java.util.*;
//
//class Person implements Comparable<Person> {
//
//    String name;
//    int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("<%s, %d>", name, age);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person person = (Person) o;
//        return age == person.age && Objects.equals(name, person.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return name.charAt(0) * age;
//    }
//
//    @Override
//    public int compareTo(Person o) {
//        return 0;
//    }
//}
//
//class Project {
//
//    int workingHours;
//    int hourlySalary;
//
//    public Project(int workingHours, int hourlySalary) {
//        this.workingHours = workingHours;
//        this.hourlySalary = hourlySalary;
//    }
//
//    public int totalSalary() {
//        return workingHours * hourlySalary;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("<%d, %d>", workingHours, hourlySalary);
//    }
//}
//
//public class Solution {
//    public static void main(String[] args) {
//        CBHT<Person,Project> table = new CBHT<Person,Project>(10);
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        for(int i = 0; i < N; i++) {
//            String name = sc.next();
//            int age = sc.nextInt();
//            int workingHours = sc.nextInt();
//            int hourlySalary = sc.nextInt();
//            Person person = new Person(name, age);
//            Project project = new Project(workingHours, hourlySalary);
//            SLLNode<MapEntry<Person,Project>> node = table.search(person);
//            if(node == null) {
//                table.insert(person, project);
//            } else {
//                Project prev_project = node.element.value;
//                if(prev_project.totalSalary() >= project.totalSalary()) {
//                    table.insert(person, prev_project);
//                } else {
//                    table.insert(person, project);
//                }
//            }
//        }
//        System.out.println(table);
//    }
//}
//
