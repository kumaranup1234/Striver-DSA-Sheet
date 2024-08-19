package Stack;

import java.util.Stack;

public class minStack {
    Stack<Integer> s;
    Stack<Integer> min;

    public minStack() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        s.push(val);
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }

    public void pop() {
        if (s.isEmpty()) {
            return;
        }
        int top = s.peek();
        if(top == min.peek()){
            min.pop();
        }
        s.pop();
    }

    public int top() {
        if (s.isEmpty()) {
            return 0;
        }
        return s.peek();
    }

    public int getMin() {
        if(min.isEmpty()){
            return 0;
        }

        return min.peek();
    }
}
