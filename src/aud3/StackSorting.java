package aud3;

import Ispitni.Array;

public class StackSorting {
    public static ArrayStack<Integer> sortstack(ArrayStack<Integer> stack) {
        ArrayStack<Integer> tmpStack = new ArrayStack<>(100);
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                stack.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }
        return tmpStack;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> input = new ArrayStack<Integer>(100);
        input.push(3);
        input.push(2);
        input.push(1);

        ArrayStack<Integer> tmpStack=sortstack(input);
        while (!tmpStack.isEmpty()) {
            System.out.print(tmpStack.pop()+" ");
        }
    }
}
