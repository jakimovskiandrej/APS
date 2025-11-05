package aud7;

import java.util.Scanner;

public class Povikuvaci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        OBHT<String,String> table = new OBHT<>(2*N);
        for(int i=0;i<N;i++) {
            String[] parts = sc.nextLine().split(" ");
            String code = parts[0];
            String country = parts[1];
            table.insert(code,country);
        }
        String numberToSearch = sc.nextLine();
        String codeToCheck = "";
        String result = numberToSearch.substring(1);
        if(result.charAt(0) == '1') {
            codeToCheck = result.substring(0,1);
        } else if(result.charAt(0) == '2') {
            codeToCheck = result.substring(0,2);
        } else if(result.charAt(0) == '3') {
            codeToCheck = result.substring(0,3);
        }
        int index = table.search(codeToCheck);
        if(index == -1) {
            System.out.println("NO");
        } else {
            System.out.println(table.getBucket(index).value);
        }
    }
}
