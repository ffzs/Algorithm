package longestCommonSubsequence;

/**
 * @author: ffzs
 * @Date: 2021/4/3 上午9:21
 */
public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray(), c2 = text2.toCharArray();
        int m = c1.length, n = c2.length;

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i-1] == c2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m][n];
    }

}
