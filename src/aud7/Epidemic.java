package aud7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Epidemic {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String,Integer> positive = new CBHT<String,Integer>(100);
        CBHT<String,Integer> negative = new CBHT<String,Integer>(100);
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] parts = input.split(" ");
            if(parts[2].equals("positive")) {
                if(positive.search(parts[0]) == null) {
                    positive.insert(parts[0], 1);
                } else {
                    SLLNode<MapEntry<String,Integer>> current = positive.search(parts[0]);
                    positive.insert(parts[0], current.element.value+1);
                }
            }
            if(parts[2].equals("negative")) {
                if(negative.search(parts[0]) == null) {
                    negative.insert(parts[0], 1);
                } else {
                    SLLNode<MapEntry<String,Integer>> current = negative.search(parts[0]);
                    negative.insert(parts[0], current.element.value+1);
                }
            }
        }
        String municipality = br.readLine();
        SLLNode<MapEntry<String,Integer>> negativeRes = negative.search(municipality);
        SLLNode<MapEntry<String,Integer>> positiveRes = positive.search(municipality);
        Integer positiveCounter = positiveRes.element.value;
        Integer negativeCounter = negativeRes.element.value;
        double factor = (double) positiveCounter / (positiveCounter + negativeCounter);
        System.out.printf("%.2f%n", factor);
    }

}
