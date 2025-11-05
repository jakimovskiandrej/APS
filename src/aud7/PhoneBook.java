package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneBook {

    private static String normalizeNumber(String input) {
        if(input.startsWith("+389")) {
            return "0" + input.substring(4);
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String,String> table = new CBHT<String,String>(2*N);
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            String[] parts = input.split(" ");
            String normalized = normalizeNumber(parts[0]);
            table.insert(normalized, parts[1]);
        }
        String number = br.readLine();
        String normalizedQuery = normalizeNumber(number);
        SLLNode<MapEntry<String,String>> current = table.search(normalizedQuery);
        if(current == null) {
            System.out.println("Unknown number");
        } else {
            System.out.println(current.element.value);
        }
    }
}
