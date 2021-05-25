package strangePrinter;

/**
 * @author: ffzs
 * @Date: 2021/5/24 上午8:09
 */
public class Solution {

    public int strangePrinter(String s) {
        char[] cs = s.toCharArray();

        int n = cs.length;

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (cs[i] == cs[j]) dp[i][j] = dp[i][j-1];
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k+1][j]);
                    }
                    dp[i][j] = min;
                }
            }

        }
        return dp[0][n-1];
    }

}
