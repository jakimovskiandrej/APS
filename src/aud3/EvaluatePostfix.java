package aud3;

import Ispitni.Array;

public class EvaluatePostfix {
    public static int evaluatePostfix(String[] arr) {
        ArrayStack<Integer> stack = new ArrayStack<>(100);
        for(String token : arr) {
            if(token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            }
            else {
                int value1 = stack.pop();
                int value2 = stack.pop();
                switch(token) {
                    case "+":
                    stack.push(value2 + value1);
                    break;
                    case "-":
                    stack.push(value2 - value1);
                    break;
                    case "*":
                    stack.push(value2 * value1);
                    break;
                    case "/":
                    stack.push(value2 / value1);
                    break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(evaluatePostfix(arr));
    }
}
