package minCut;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/3/8 上午8:41
 */
public class Solution2 {

    public int minCut(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] f = new boolean[n][n];
        for (boolean[] it : f) {
            Arrays.fill(it, true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = cs[i] == cs[j] && f[i+1][j-1];
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, n-1);
        for (int i = 0; i < n; i++) {
            if (f[0][i]) dp[i] = 1;
            else {
                for (int j = 0; j < i; j++) {
                    if (f[i][j]) {
                        dp[i] = Math.min(dp[i], dp[j-1] +1);
                    }
                }
            }
        }

        return dp[n-1]-1;
    }

}
