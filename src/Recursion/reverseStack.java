package Recursion;

import java.util.Stack;

public class reverseStack {
    public static void reverse(Stack<Integer> s) {
        if(s.isEmpty()) return;

        int top = s.pop();
        reverse(s);
        System.out.println(top);
        insertAtTop(s, top);
    }

    public static void insertAtTop(Stack<Integer> s, int i) {
        if(s.isEmpty()) {
            s.push(i);
            return;
        }
        int top = s.pop();
        insertAtTop(s, i);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Printing the original stack
        System.out.println("Original Stack: " + stack);

        // Reversing the stack
        reverse(stack);

        // Printing the reversed stack
        System.out.println("Reversed Stack: " + stack);

    }
}
