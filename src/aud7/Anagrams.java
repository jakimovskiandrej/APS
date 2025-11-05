package aud7;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String,Integer> table = new CBHT<String,Integer>(2*N);
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            char[] chars = input.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(table.search(sorted) == null) {
                table.insert(sorted, 1);
            } else {
                SLLNode<MapEntry<String,Integer>> current = table.search(sorted);
                table.insert(sorted, current.element.value+1);
            }
        }
        String word = br.readLine();
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        SLLNode<MapEntry<String,Integer>> current = table.search(sorted);
        System.out.println(current.element.value);
    }

}
