//package aud7;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Objects;
//
//class Lek {
//    String name;
//    String type;
//    int price;
//
//    public Lek(String name, String type, int price) {
//        this.name = name;
//        this.type = type;
//        this.price = price;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Lek lek = (Lek) o;
//        return price == lek.price && Objects.equals(name, lek.name) && Objects.equals(type, lek.type);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hashCode(name);
//        result = 31 * result + Objects.hashCode(type);
//        result = 31 * result + price;
//        return result;
//    }
//}
//
//public class Magacin {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        CBHT<String, ArrayList<Lek>> table = new CBHT<>(2*N);
//        for(int i = 0; i < N; i++) {
//            String line = br.readLine();
//            String[] parts = line.split("@");
//            String name = parts[0];
//            String type = parts[1];
//            int price = Integer.parseInt(parts[2]);
//            Lek lek = new Lek(name, type, price);
//            if(table.search(parts[1]) == null) {
//                ArrayList<Lek> lekovi = new ArrayList<>();
//                lekovi.add(lek);
//                table.insert(parts[1], lekovi);
//            } else {
//                SLLNode<MapEntry<String,ArrayList<Lek>>> current = table.search(parts[1]);
//                ArrayList<Lek> element = current.element.value;
//                element.add(lek);
//                table.insert(parts[1],element);
//            }
//        }
//        String line = br.readLine();
//        SLLNode<MapEntry<String,ArrayList<Lek>>> current = table.search(line);
//        if(current != null) {
//            Lek minLek = current.element.value.get(0);
//            for (Lek lek : current.element.value) {
//                if(lek.getPrice() < minLek.getPrice()) {
//                    minLek = lek;
//                }
//            }
//            System.out.println(minLek.getName());
//        } else {
//            System.out.printf("No such element");
//        }
//    }
//}
