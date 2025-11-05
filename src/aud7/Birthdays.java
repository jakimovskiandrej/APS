package aud7;

import java.util.Map;
import java.util.Scanner;

public class Birthdays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        CBHT<String,Integer> table = new CBHT<>(23);
        for(int i=0;i<n;i++) {
            String[] parts = sc.nextLine().split("\\.");
            if(table.search(parts[1]) == null) {
                table.insert(parts[1],1);
            } else {
                SLLNode<MapEntry<String,Integer>> current = table.search(parts[1]);
                table.insert(parts[1],current.element.value+1);
            }
        }
        String toSearch = sc.nextLine();
        SLLNode<MapEntry<String,Integer>> current = table.search(toSearch);
        if(current == null) {
            System.out.println("Empty");
        } else {
            System.out.println(current.element.value);
        }
    }
}
