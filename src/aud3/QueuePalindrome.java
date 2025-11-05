package aud3;

public class QueuePalindrome {
    public static boolean isPalindrome(String input) {
        ArrayQueue<Character> queue = new ArrayQueue<>(100);
        ArrayStack<Character> stack = new ArrayStack<>(100);
        for(char c : input.toCharArray()) {
            queue.enqueue(c);
            stack.push(c);
        }
        while(!queue.isEmpty()) {
            if(queue.dequeue().equals(stack.pop())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String test = "level";
        System.out.println(isPalindrome(test));
    }
}
