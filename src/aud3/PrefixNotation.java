package aud3;

public class PrefixNotation { //Prefix to infix
    public static boolean isOperator(char x) {
        return switch (x) {
            case '+', '-', '*', '/', '^', '%' -> true;
            default -> false;
        };
    }

    public static String convert(String s) {
        Stack<String> stack = new ArrayStack<>(100);
        for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if(isOperator(c)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            }
            else {
                stack.push(c + "");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        System.out.println("Infix : " + convert(exp));
    }
}
