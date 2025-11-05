//package aud7;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Objects;
//
//class Covek {
//
//    String name;
//    String date;
//
//    public Covek(String name, String date) {
//        this.name = name;
//        this.date = date;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Covek covek = (Covek) o;
//        return Objects.equals(name, covek.name) && Objects.equals(date, covek.date);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hashCode(name);
//        result = 31 * result + Objects.hashCode(date);
//        return result;
//    }
//}
//
//public class Rodendeni {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        CBHT<String, ArrayList<Covek>> table = new CBHT<>(1000);
//        for(int i = 0; i < N; i++) {
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//            Covek c = new Covek(parts[0], parts[1]);
//            String[] dateParts = parts[1].split("\\.");
//            String monthKey = dateParts[1];
//            if(table.search(monthKey) == null) {
//                ArrayList<Covek> list = new ArrayList<>();
//                list.add(c);
//                table.insert(monthKey, list);
//            } else {
//                SLLNode<MapEntry<String,ArrayList<Covek>>> current = table.search(monthKey);
//                ArrayList<Covek> list = current.element.value;
//                list.add(c);
//                table.insert(monthKey, list);
//            }
//        }
//        String month = br.readLine();
//        SLLNode<MapEntry<String,ArrayList<Covek>>> current = table.search(month);
//        if(current == null) {
//            System.out.println("Empty");
//        } else {
//            ArrayList<Covek> c = current.element.value;
//            for (Covek covek : c) {
//                System.out.println(covek.getName());
//            }
//        }
//    }
//}
