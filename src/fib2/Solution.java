package fib2;

/**
 * @author: ffzs
 * @Date: 2021/9/4 上午6:49
 */
public class Solution {

    public int fib(int n) {
        if (n <= 1) return n;
        final int MOD = (int)(1e9)+7;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]);
            if (dp[i] > MOD) {
                dp[i] -= MOD;
            }
        }
        return dp[n];
    }
}
