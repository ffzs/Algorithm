package numRollsToTarget;

/**
 * @author: ffzs
 * @Date: 2023/10/24 上午7:39
 */
public class Solution {

    private static final int MOD = (int)1e9+7;

    public int numRollsToTarget(int n, int k, int target) {
        int t = n*k;
        if (target > t) return 0;
        int[][] dp = new int[n+1][t+1];
        for (int i = 0; i <= Math.min(k, target); i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < n; i++) {
            for (int j = i; j <= t; j++) {
                for (int l = 1; l <= k && l <= j; l++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-l])%MOD;
                }
            }
        }

        return dp[n][target];
    }

}
