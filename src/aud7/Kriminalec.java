package aud7;

import java.util.ArrayList;
import java.util.Scanner;

public class Kriminalec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        OBHT<String,ArrayList<String>> table = new OBHT<>(2*N);
        ArrayList<String> sequences = new ArrayList<>();
        for(int i=0;i<N;i++) {
            String name = sc.nextLine();
            String seq1 = sc.nextLine();
            String seq2 = sc.nextLine();
            sequences.add(seq1);
            sequences.add(seq2);
            table.insert(name,sequences);
        }
        String codeToSearch = sc.nextLine();
        int index = table.search(codeToSearch);
        if(index == -1) {
            System.out.println("Unknown");
        } else {
            System.out.println(table.getBucket(index).value);
        }
    }
}
