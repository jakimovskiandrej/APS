//package aud3;
//
//import java.util.*;
//import java.util.Queue;
//
//class Student {
//    String name;
//    int science;
//    int scifi;
//    int history;
//
//    public Student(String name, int science, int scifi, int history) {
//        this.name = name;
//        this.science = science;
//        this.scifi = scifi;
//        this.history = history;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getScience() {
//        return science;
//    }
//
//    public int getScifi() {
//        return scifi;
//    }
//
//    public int getHistory() {
//        return history;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//}
//
//public class Library {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        Queue<Student> science = new LinkedList<>();
//        Queue<Student> scifi = new LinkedList<>();
//        Queue<Student> history = new LinkedList<>();
//        for(int i = 0; i < n; i++) {
//            String name = sc.nextLine();
//            int scienceGrade = sc.nextInt();
//            int scifiGrade = sc.nextInt();
//            int historyGrade = sc.nextInt();
//            sc.nextLine();
//            Student student = new Student(name, scienceGrade, scifiGrade, historyGrade);
//            if(scienceGrade == 1) {
//                science.add(student);
//            } else if(scifiGrade == 1) {
//                scifi.add(student);
//            } else if(historyGrade == 1) {
//                history.add(student);
//            }
//        }
//        while (!science.isEmpty()) {
//            Student student = science.poll();
//            if(student.scifi==1) {
//                scifi.add(student);
//            } else if (student.history==1) {
//                history.add(student);
//            } else {
//                System.out.println(student.name);
//            }
//        }
//        while(!scifi.isEmpty()) {
//            Student student = scifi.poll();
//            if(student.history==1) {
//                history.add(student);
//            } else {
//                System.out.println(student.name);
//            }
//        }
//        while(!history.isEmpty()) {
//            Student student = history.poll();
//            System.out.println(student.name);
//        }
//        sc.close();
//    }
//}
