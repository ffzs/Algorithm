package MinStack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> values = new Stack<>();
    Stack<Integer> min_values = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        min_values.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        values.add(x);
        if (min_values.peek()>=x) min_values.add(x);
    }

    public void pop() {
        if (!values.isEmpty()){
            int top = values.pop();
            if (top==min_values.peek()) min_values.pop();
        }
    }

    public int top() {
        if(!values.isEmpty())
            return values.peek();
        else
            throw new NullPointerException();
    }

    public int getMin() {
        if (!values.isEmpty())
            return min_values.peek();
        else
            throw new NullPointerException();
    }
}
