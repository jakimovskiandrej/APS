package aud7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RedCross {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OBHT<String,Integer> table = new OBHT<String,Integer>(11);
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++) {
            String input = br.readLine();
            String[] parts = input.split(" ");
            String key = parts[1];
            key = key.replaceAll("[1-2]", "");
            if(table.search(key) == -1) {
                table.insert(key, 1);
            } else {
                table.insert(key,table.getBucket(table.search(key)).value+1);
            }
        }
        System.out.println(table);
    }
}
