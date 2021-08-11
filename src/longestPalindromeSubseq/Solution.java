package longestPalindromeSubseq;

/**
 * @author: ffzs
 * @Date: 2021/8/12 上午6:50
 */
public class Solution {

    public int longestPalindromeSubseq(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n <= 1) return n;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (cs[i] == cs[j]) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[0][n-1];
    }

}
