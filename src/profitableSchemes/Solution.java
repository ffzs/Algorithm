package profitableSchemes;

/**
 * @author: ffzs
 * @Date: 2021/6/9 上午7:03
 */
public class Solution {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int MOD = 1_000_000_000 + 7;
        int[][] dp = new int[n+1][minProfit+1];
        dp[0][0] = 1;
        for (int i = 0; i < len; i++) {
            int g  = group[i], p = profit[i];
            for (int j = n; j >= g; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j-g][Math.max(0, k-p)])%MOD;
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= n; i++) {
            res = (res + dp[i][minProfit]) % MOD;
        }
        return res;
    }

    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int MOD = (int)1e9 + 7;
        int[][][] dp = new int[len+1][n+1][minProfit+1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if(j < group[i-1]) dp[i][j][k] = dp[i-1][j][k];
                    else {
                        dp[i][j][k] = (dp[i-1][j][k] + dp[i-1][j-group[i-1]][Math.max(0, k - profit[i-1])]) % MOD;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= n; i++) {
            res = (res + dp[len][i][minProfit]) % MOD;
        }
        return res;
    }

}
