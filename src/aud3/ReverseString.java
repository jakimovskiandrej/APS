package aud3;

public class ReverseString {

    public static String reverse(String s) {
        ArrayStack<Character> stack = new ArrayStack<>(100);
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            stack.push(c);
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String s = "geeksforgeeks";
        System.out.println(s);
        System.out.println(reverse(s));
    }
}
