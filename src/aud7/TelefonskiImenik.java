package aud7;

import java.util.Scanner;

public class TelefonskiImenik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        CBHT<String,String> table = new CBHT<>(2*N);
        for(int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String num = parts[0];
            String number = num.substring(1);
            String user = parts[1];
            table.insert(number,user);
        }
        String numberToSearch = sc.nextLine();
        String resultNumber = numberToSearch.substring(4);
        SLLNode<MapEntry<String,String>> result = table.search(resultNumber);
        if(result == null) {
            System.out.println("Unknown number");
        } else {
            System.out.println(result.element.value);
        }
    }
}
