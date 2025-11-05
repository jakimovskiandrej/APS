package aud3;

import java.util.Scanner;

public class Modificiran {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new ArrayStack<>(100);
        while (true) {
            String line = sc.nextLine().trim();
            if(line.equals("x")) {
                break;
            }
            if(line.startsWith("end")) {
                String name = line.substring(3);
                if(stack.isEmpty() || !stack.peek().equals(name)) {
                    System.out.println("Invalid");
                    return;
                }
                stack.pop();
            } else {
                stack.push(line);
            }
        }
        if(stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
