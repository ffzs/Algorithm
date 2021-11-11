package kInversePairs;

import com.sun.source.tree.BreakTree;

/**
 * @author: ffzs
 * @Date: 2021/11/11 上午7:27
 */
public class Solution {
    static final int MOD = 1_000_000_007;
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n+1][k+1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = 0; j <= k; j++) {
                sum += dp[i-1][j];
                if (j + 1 > i) sum -= dp[i-1][j-i];
                dp[i][j] = (dp[i][j] + sum) % MOD;
            }
        }
        return (int)dp[n][k];
    }
}
