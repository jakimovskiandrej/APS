package aud3;

public class ValidParentheses {
    public static boolean isBalanced(String s) {
        ArrayStack<String> stack = new ArrayStack<String>(100);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c + "");
            }
            else {
                if(!stack.isEmpty() && stack.peek().equals("{") && c == ('}')
                        || stack.peek().equals("[") && c == (']')
                        || stack.peek().equals("(") && c == (')')) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{([])}";
        if (isBalanced(s))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
