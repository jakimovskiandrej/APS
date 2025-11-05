//package aud7;
//
//import java.io.*;
//import java.util.*;
//
//class Name implements Comparable<Name> {
//
//    String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Name(String name) {
//        this.name = name.toUpperCase();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Name name1 = (Name) o;
//        return Objects.equals(name, name1.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return (100*name.charAt(0) + name.charAt(1));
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//
//    @Override
//    public int compareTo(Name o) {
//        return name.compareTo(o.name);
//    }
//}
//
//public class Statistics {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        CBHT<Name,Integer> tableM, tableF;
//        tableM = new CBHT<Name,Integer>(9091);
//        tableF = new CBHT<Name,Integer>(9091);
//        int N = Integer.parseInt(br.readLine());
//        for(int i = 1; i <= N; i++) {
//            String line = br.readLine();
//            String[] parts = line.split(" ");
//            Name nameUpper = new Name(parts[0].toUpperCase());
//            if(parts[1].compareTo("M") == 0) {
//                SLLNode<MapEntry<Name,Integer>> resM = tableM.search(nameUpper);
//                if(resM == null) {
//                    tableM.insert(nameUpper, 1);
//                } else {
//                    int oldValue = resM.element.value;
//                    tableF.insert(nameUpper, oldValue);
//                }
//            }
//            if(parts[1].compareTo("F") == 0) {
//                SLLNode<MapEntry<Name,Integer>> resF = tableF.search(nameUpper);
//                if(resF == null) {
//                    tableF.insert(nameUpper, 1);
//                } else {
//                    int oldValue = resF.element.value;
//                    tableF.insert(nameUpper, oldValue);
//                }
//            }
//        }
//        String sex = br.readLine().toUpperCase();
//        String names = br.readLine().toUpperCase();
//        while (names.compareTo("END")!=0) {
//            if(sex.compareTo("M")==0) {
//                SLLNode<MapEntry<Name,Integer>> dviziM = tableM.getFirst(new Name(names));
//                SLLNode<MapEntry<Name,Integer>> current;
//                for(current=dviziM; current!=null; current=current.succ) {
//                    System.out.println(current.element.key.getName());
//                }
//                SLLNode<MapEntry<Name,Integer>> dviziF = tableM.getFirst(new Name(names));
//                if(dviziF == null) {
//                    System.out.println("No such name");
//                    names = br.readLine().toUpperCase();
//                } else {
//                    System.out.println(sex + " " + dviziF.element.key.toString() + " " + dviziF.element.value.toString());
//                    names = br.readLine().toUpperCase();
//                }
//            }
//            if(sex.compareTo("F")==0) {
//                SLLNode<MapEntry<Name,Integer>> dviziM = tableF.getFirst(new Name(names));
//                SLLNode<MapEntry<Name,Integer>> current;
//                for(current=dviziM; current!=null; current=current.succ) {
//                    System.out.println(current.element.key.getName());
//                }
//                SLLNode<MapEntry<Name,Integer>> dviziF = tableF.getFirst(new Name(names));
//                if(dviziF == null) {
//                    System.out.println("No such name");
//                    names = br.readLine().toUpperCase();
//                } else {
//                    System.out.println(sex + " " + dviziF.element.key.toString() + " " + dviziF.element.value.toString());
//                    names = br.readLine().toUpperCase();
//                }
//            }
//        }
//    }
//
//}
