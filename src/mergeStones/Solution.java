package mergeStones;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/4/4 上午7:57
 */
public class Solution {

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;

        int[][] dp = new int[n][n];
        int[] sum = new int[n+1];

        for(int i = 0; i < n; ++ i) {
            sum[i + 1] = sum[i] + stones[i];
        }

        for (int len = k; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE>>1;
                for (int p = i; p < j; p+=(k-1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][p] + dp[p+1][j]);
                }

                if ((len - 1) % (k-1) == 0) dp[i][j] += sum[j+1] - sum[i];
            }
        }
        return dp[0][n-1];
    }

}
