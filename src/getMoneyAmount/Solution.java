package getMoneyAmount;

/**
 * @author: ffzs
 * @Date: 2021/11/12 上午7:34
 */
public class Solution {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = (i + j) >>> 1; k < j; k++) {
                    int c = k + Math.max(dp[i][k-1], dp[k+1][j]);
                    min = Math.min(min, c);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }

}
