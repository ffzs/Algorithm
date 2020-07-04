package longestValidParentheses;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/4
 */
public class Solution3 {
    public static int longestValidParentheses(String s) {
        int res = 0;
        char[] seq = (" "+s).toCharArray();
        int[] dp = new int[seq.length+1];
        for (int i = 1; i < seq.length; i++) {
            if (seq[i] == ')') {
                if (seq[i-1] == '(') dp[i+1] = dp[i-1] + 2;
                else if (seq[i- dp[i] -1] == '(') dp[i+1] = dp[i] + 2 + dp[i- dp[i] -1];
                res = Math.max(res, dp[i+1]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }
}
