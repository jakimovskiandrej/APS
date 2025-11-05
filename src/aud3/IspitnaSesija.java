package aud3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IspitnaSesija {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        ArrayStack<String> stack = new ArrayStack<>(100);
        String[] knigi = br.readLine().split("\\s+");
        String[] ispiti = br.readLine().split("\\s+");
        for (String s : knigi) {
            stack.push(s);
        }
        List<String> bookList = Arrays.asList(knigi);
        int[] count = new int[M];
        for (String exam : ispiti) {
            ArrayStack<String> tempStack = new ArrayStack<>(100);
            while (!stack.isEmpty()) {
                String top = stack.pop();
                int index = bookList.indexOf(top);
                tempStack.push(top);
                count[index]++;
                if(top.equals(exam)) {
                    break;
                }
            }
            while (!tempStack.isEmpty()) {
                String k = tempStack.pop();
                if(!k.equals(exam)) {
                    stack.push(k);
                }
            }
            stack.push(exam);
        }
        for(int i = 0; i < M; i++) {
            System.out.printf("%s %s%n", bookList.get(i), count[i]);
        }
    }
}
