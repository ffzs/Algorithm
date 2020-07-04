package longestValidParentheses;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/4
 */
public class Solution {
    public static int longestValidParentheses(String s) {
        char[] seq = s.toCharArray();
        int[] stack = new int[seq.length+1];
        stack[0] = -1;
        int res = 0, index = 1, max = 0;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == '(') {
                stack[index++] = i;
            }
            else {
                index --;
                if (index == 0) stack[index++] = i;
                else res = Math.max(res, i - stack[index-1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(())()(()((";
        System.out.println(longestValidParentheses(s));
    }
}
