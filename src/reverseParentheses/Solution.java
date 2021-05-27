package reverseParentheses;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2021/5/26 上午7:51
 */
public class Solution {

    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        int i = 0, dir = 1;
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                dir = -dir;
            }
            else sb.append(s.charAt(i));
            i += dir;
        }
        return sb.toString();
    }

}
