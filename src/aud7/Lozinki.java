package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Lozinki {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = 2 * N;
        HashMap<String,String> table = new HashMap<>(size);
        for(int i = 1; i <= N; i++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            String password = parts[1];
            table.put(name,password);
        }
        String attempt = "";
        while (!attempt.equals("KRAJ")) {
            attempt = br.readLine();
            if(!attempt.equals("KRAJ")) {
                String[] parts = attempt.split(" ");
                String name = parts[0];
                String password = parts[1];
                if(table.containsKey(name) && table.get(name).equals(password)) {
                    System.out.println("Najaven");
                    break;
                } else {
                    System.out.println("Nenajaven");
                }
            }
        }
    }

}
