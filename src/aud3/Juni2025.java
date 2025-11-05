package aud3;

import java.util.Scanner;

public class Juni2025 {
    public static void main(String[] args) {
        ArrayStack<Character> stack = new ArrayStack<>(100);
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < N; i++) {
            String line = sc.nextLine();
            if(line.startsWith("TYPE")) {
                Character c = line.charAt(5);
                sb.append(c);
                stack.push(c);
            } else if(line.startsWith("UNDO")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                    sb.setLength(stack.size());
                }
            } else if(line.startsWith("SHOW")) {
                System.out.println(sb.toString());
            }
        }
    }
}
