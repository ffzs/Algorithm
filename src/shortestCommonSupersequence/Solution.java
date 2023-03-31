package shortestCommonSupersequence;

/**
 * @author: ffzs
 * @Date: 2023/3/28 上午9:10
 */
public class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        char[] cs1 = str1.toCharArray();
        char[] cs2 = str2.toCharArray();
        int m = cs1.length, n = cs2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cs1[i - 1] == cs2[j - 1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        while (i != 0 || j != 0) {
            if (i == 0) sb.append(cs2[--j]);
            else if (j == 0) sb.append(cs1[--i]);
            else {
                if (dp[i-1][j] == dp[i][j]) sb.append(cs1[--i]);
                else if (dp[i][j-1] == dp[i][j]) sb.append(cs2[--j]);
                else {
                    sb.append(cs1[--i]);
                    --j;
                }
            }
        }

        return sb.reverse().toString();
    }

}
