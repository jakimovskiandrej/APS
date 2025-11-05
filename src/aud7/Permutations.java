package aud7;

import java.util.Arrays;
import java.util.Scanner;

public class Permutations {

    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        OBHT<String,Integer> table = new OBHT<>(N);
        for(int i=0;i<N;i++) {
            String word = sc.nextLine();
            String key = sortString(word);
            int count = table.search(key);
            if(count == -1) {
                table.insert(key,1);
            } else {
                table.insert(key,count+1);
            }
        }
        String target = sc.nextLine();
        String targetKey = sortString(target);
        int result = table.search(targetKey);
        if(result == -1) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
