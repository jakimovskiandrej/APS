package aud3;

import java.io.*;

public class PostFixEvaluation {

    public static int evaluatePostfix(char[] expression, int length) {
        ArrayStack<Integer> stack = new ArrayStack<>(100);
        for(int i = 0; i < length; i++) {
            char c = expression[i];
            if(Character.isDigit(c)) {
                int number = 0;
                while (i < length && Character.isDigit(expression[i])) {
                    number = number * 10 + Character.getNumericValue(expression[i]);
                    i++;
                }
                stack.push(number);
                i--;
            } else if(!Character.isWhitespace(c)) {
                int a = stack.pop();
                int b = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = evaluatePostfix(exp, exp.length);
        System.out.println(rez);

        br.close();
    }
}
