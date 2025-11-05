//package aud3;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//class Student {
//    String name;
//    boolean documents;
//    boolean index;
//    boolean documentsHighSchool;
//
//    public Student(String name, boolean documents, boolean index, boolean documentsHighSchool) {
//        this.name = name;
//        this.documents = documents;
//        this.index = index;
//        this.documentsHighSchool = documentsHighSchool;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public boolean isDocuments() {
//        return documents;
//    }
//
//    public boolean isIndex() {
//        return index;
//    }
//
//    public boolean isDocumentsHighSchool() {
//        return documentsHighSchool;
//    }
//}
//
//public class Courses4 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        ArrayQueue<Student> documentsQueue = new ArrayQueue<>(100);
//        ArrayQueue<Student> indexQueue = new ArrayQueue<>(100);
//        ArrayQueue<Student> documentsHighSchoolQueue = new ArrayQueue<>(100);
//        ArrayList<String> students = new ArrayList<>();
//
//        for(int i=0;i<n;i++) {
//            String name = sc.nextLine();
//            boolean documents = sc.nextLine().equals("1");
//            boolean index = sc.nextLine().equals("1");
//            boolean documentsHighSchool = sc.nextLine().equals("1");
//            Student s = new Student(name, documents, index, documentsHighSchool);
//            if(s.documents) {
//                documentsQueue.enqueue(s);
//            }
//            if(s.index) {
//                indexQueue.enqueue(s);
//            }
//            if(s.documentsHighSchool) {
//                documentsHighSchoolQueue.enqueue(s);
//            }
//        }
//        while(!documentsQueue.isEmpty() || !indexQueue.isEmpty() || !documentsHighSchoolQueue.isEmpty()) {
//            for(int i=0;i<2 && !documentsQueue.isEmpty();i++) {
//                Student s = documentsQueue.dequeue();
//                s.documents = false;
//                if(!s.documentsHighSchool && !s.index && !students.contains(s.name)) {
//                    students.add(s.name);
//                }
//            }
//            for(int i=0;i<2 && !indexQueue.isEmpty();i++) {
//                Student s = indexQueue.dequeue();
//                s.index = false;
//                if(!s.documentsHighSchool && !s.documents && !students.contains(s.name)) {
//                    students.add(s.name);
//                }
//            }
//            for(int i=0;i<1 && !documentsHighSchoolQueue.isEmpty();i++) {
//                Student s = documentsHighSchoolQueue.dequeue();
//                s.documentsHighSchool = false;
//                if(!s.index && !s.documents && !students.contains(s.name)) {
//                    students.add(s.name);
//                }
//            }
//        }
//        for (String student : students) {
//            System.out.println(student);
//        }
//    }
//}
