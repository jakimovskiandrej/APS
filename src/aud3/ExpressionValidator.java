package aud3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpressionValidator {

    public static int prednost(char op) {
        if(op == '*') return 2;
        if(op == '+') return 1;
        return 0;
    }

    public static int applyOp(int n1,int n2,char op) {
        if(op == '+') return n1 + n2;
        if(op == '*') return n1 * n2;
        if(op == '-') return n1 - n2;
        if(op == '/') return n1 / n2;
        return 0;
    }

    public static int evaluateExpression(String expression){
        ArrayStack<Integer> stack = new ArrayStack<>(100);
        ArrayStack<Character> ops = new ArrayStack<>(100);
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(Character.isDigit(c)) {
                int num = 0;
                while (i<expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + c - '0';
                    i++;
                }
                i--;
                stack.push(num);
            } else if(c == '+' || c == '*' || c == '-' || c == '/') {
                while (!ops.isEmpty() && prednost(ops.peek()) >= prednost(c)) {
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(applyOp(val2,val1,ops.pop()));
                }
                ops.push(c);
            }
        }

        while(!ops.isEmpty()) {
            int val2 = stack.pop();
            int val1 = stack.pop();
            stack.push(applyOp(val2,val1,ops.pop()));
        }

        return stack.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String expr = input.readLine();
        int result = evaluateExpression(expr);
        System.out.println(result);
    }
}
