package evalRPN;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2021/3/20 上午7:35
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        if (tokens.length < 3) return 0;
        Deque<Integer> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int b = stack.pop();
                    int a = stack.pop();
                    switch (t) {
                        case "+":
                            stack.push(a + b);
                            break;
                        case "-":
                            stack.push(a - b);
                            break;
                        case "*":
                            stack.push(a * b);
                            break;
                        case "/":
                            stack.push(a / b);
                            break;
                    }
                    break;
                default:
                    stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }
}
