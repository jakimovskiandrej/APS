package aud3;

public class ReverseWords {

    public static String reverseWords(String s) {
        ArrayStack<String> stack = new ArrayStack<>(100);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(Character.isLetter(s.charAt(i)) && s.charAt(i)!=' ') {
                stack.push(String.valueOf(s.charAt(i)));
            }
            else {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Geeks for Geeks";
        String reversed = reverseWords(str);
        System.out.println(reversed);
    }
}
