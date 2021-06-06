package findMaxForm;

/**
 * @author: ffzs
 * @Date: 2021/6/6 下午3:28
 */
public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int c0 = 0, c1 = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') c0++;
                else c1++;
            }
            for (int j = m; j >= c0; --j) {
                for (int k = n; k >= c1; --k) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - c0][k - c1] + 1);
                }
            }

        }

        return dp[m][n];
    }
}
