package aud7;

import java.util.Scanner;

public class CrvenKrst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        OBHT<String,Integer> table = new OBHT<>(2*N);
        //Alek A1+
        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            String type = parts[1];
            type = type.replaceAll("[1-2]","");
            if(table.search(type) == -1) {
                table.insert(type,1);
            } else {
                table.insert(type,table.getBucket(table.search(type)).value+1);
            }
        }
        System.out.println(table);
    }
}
