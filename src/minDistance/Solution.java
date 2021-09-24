package minDistance;

/**
 * @author: ffzs
 * @Date: 2021/9/25 上午6:44
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        int m = cs1.length, n = cs2.length;

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            char c1 = cs1[i-1];
            for (int j = 1; j <= n; j++) {
                char c2 = cs2[j-1];
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int len = dp[m][n];
        return m + n - 2*len;
    }

}
