package isValid;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: ffzs
 * @Date: 2020/8/14 上午7:35
 */
public class Solution {
    public boolean isValid(String s) {
        char[] seq = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();

        int i = 0;
        while (i < seq.length) {
            char c = seq[i];
            if (c == '('||c == '[' || c == '{') {
                stack.push(c);

            }
            else {
                if (stack.isEmpty()) return false;
                int minus = c - stack.pop();
                if (minus != 1 && minus != 2) return false;
            }
            i ++;
        }
        return stack.isEmpty();
    }
}
