package aud7;

import java.util.Scanner;

public class Epidemija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        CBHT<String,Integer> tablePositive = new CBHT<>(100);
        CBHT<String,Integer> tableNegative = new CBHT<>(100);
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String municipality = parts[0];
            String surname = parts[1];
            String type = parts[2];
            if(type.equals("positive")) {
                if(tablePositive.search(municipality) == null) {
                    tablePositive.insert(municipality,1);
                } else {
                    SLLNode<MapEntry<String,Integer>> current = tablePositive.search(municipality);
                    tablePositive.insert(municipality,current.element.value+1);
                }
            } else if(type.equals("negative")) {
                if(tableNegative.search(municipality) == null) {
                    tableNegative.insert(municipality,1);
                } else {
                    SLLNode<MapEntry<String,Integer>> current = tableNegative.search(municipality);
                    tableNegative.insert(municipality,current.element.value+1);
                }
            }
        }
        String municipality = sc.nextLine();
        SLLNode<MapEntry<String,Integer>> positiveRes = tablePositive.search(municipality);
        SLLNode<MapEntry<String,Integer>> negativeRes = tableNegative.search(municipality);
        Integer resPos = positiveRes.element.value;
        Integer resNeg = negativeRes.element.value;
        double factor = resPos * 1.00 / (resNeg + resPos);
        System.out.printf("%.2f%n", factor);
    }
}
