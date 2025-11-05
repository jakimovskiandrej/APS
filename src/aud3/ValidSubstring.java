package aud3;

public class ValidSubstring {

    public static int longestValidSubstring(String s) {
        ArrayStack<Integer> stack = new ArrayStack<>(100);
        int max = 0;
        stack.push(-1);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(longestValidSubstring(s));
    }
}
