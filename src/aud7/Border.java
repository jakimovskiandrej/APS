package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Border {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, String> passports = new CBHT<>(1000);
        CBHT<String, String> changedName = new CBHT<>(1000);
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String passport = line.split(" ")[0];
            String name = line.substring(passport.length()).trim();
            passports.insert(passport,name);
        }
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            String oldName = parts[0];
            String newName = parts[1];
            changedName.insert(oldName,newName);
        }
        String passportToCheck = br.readLine();
        SLLNode<MapEntry<String,String>> current = passports.search(passportToCheck);
        if(current != null) {
            String value = current.element.value;
            if(changedName.search(value) != null) {
                System.out.println("Not Allowed");
            } else {
                System.out.println("Allowed");
            }
        } else {
            System.out.println("Not allowed");
        }
    }
}
