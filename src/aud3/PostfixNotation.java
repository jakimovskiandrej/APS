package aud3;

public class PostfixNotation { //Infix to postfix
    public static int priority(char c) {
        if(c == '^') {
            return 3;
        }
        else if (c == '*' || c == '/') {
            return 2;
        }
        else if (c == '+' || c == '-') {
            return 1;
        }
        return -1;
    }

    public static String infixToPostfix(String s) {
        Stack<Character> stack = new ArrayStack<>(100);
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
            else if(!stack.isEmpty() && c == '(' ) {
                stack.push(c);
            }
            else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while(!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String expression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(expression));
    }
}
