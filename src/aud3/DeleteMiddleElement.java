package aud3;

public class DeleteMiddleElement {

    public static ArrayStack<Integer> deleteMidElement(ArrayStack<Integer> stack) {
        ArrayStack<Integer> tmpStack = new ArrayStack<>(100);
        int middle = (stack.size()+1)/2;
        for(int i = 1; i < middle; i++) {
            tmpStack.push(stack.pop());
        }
        stack.pop();
        while(!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }
        return tmpStack;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(100);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        ArrayStack<Integer> tmpStack = deleteMidElement(stack);
        while (!tmpStack.isEmpty()) {
            System.out.print(tmpStack.pop()+" ");
        }
    }
}
