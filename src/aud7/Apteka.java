//package aud7;
//
//import java.io.*;
//import java.util.*;
//
//class Lek {
//    String ime;
//    String namena;
//    int cena;
//
//    public Lek(String ime, int cena) {
//        this.ime = ime;
//        this.cena = cena;
//    }
//
//    public String getIme() {
//        return ime;
//    }
//
//    public void setIme(String ime) {
//        this.ime = ime;
//    }
//
//    public String getNamena() {
//        return namena;
//    }
//
//    public void setNamena(String namena) {
//        this.namena = namena;
//    }
//
//    public int getCena() {
//        return cena;
//    }
//
//    public void setCena(int cena) {
//        this.cena = cena;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Lek lek = (Lek) o;
//        return cena == lek.cena && Objects.equals(ime, lek.ime) && Objects.equals(namena, lek.namena);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hashCode(ime);
//        result = 31 * result + Objects.hashCode(namena);
//        result = 31 * result + cena;
//        return result;
//    }
//}
//
//public class Apteka {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        CBHT<String,List<Lek>> table = new CBHT<>(2*N-1);
//        for (int i = 0; i < N; i++) {
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//            String ime = parts[0];
//            String namena = parts[1];
//            int cena = Integer.parseInt(parts[2]);
//            if(table.search(namena) == null) {
//                table.insert(namena,new ArrayList<>());
//                table.search(namena).element.value.add(new Lek(ime,cena));
//            } else {
//                table.search(namena).element.value.add(new Lek(ime,cena));
//            }
//        }
//        String namena = br.readLine();
//        if(table.search(namena) == null) {
//            System.out.println("Нема такви лекови");
//        } else {
//            Optional<Lek> lek = table.search(namena).element.value.stream().min(Comparator.comparing(Lek::getCena));
//            lek.ifPresent(value -> System.out.println(value.getIme()));
//        }
//    }
//}
