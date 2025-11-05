package aud3;

import java.util.Scanner;

public class Courses1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayStack<String> stack = new ArrayStack<>(100);
        while (true) {
            String line = sc.nextLine();
            if(line.equals("x")) {
                break;
            }
            if(line.startsWith("end")) {
                String func = line.substring(3);
                if(stack.isEmpty() || !stack.peek().equals(func)) {
                    System.out.println("Invalid");
                    return;
                }
                stack.pop();
            } else {
                stack.push(line);
            }
        }
        if(!stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
