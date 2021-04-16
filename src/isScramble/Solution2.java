package isScramble;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/4/16 上午8:54
 */
public class Solution2 {

    public boolean isScramble(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();

        int n = cs1.length;

        boolean[][][] dp = new boolean[n][n][n+1];


        for (int len = 1; len <= n; ++len) {
            for (int i = 0; i + len <= n; i++) {
                for (int j = 0; j + len <= n; j++) {
                    if (len == 1) dp[i][j][1] = cs1[i] == cs2[j];
                    else {
                        for (int k = 1; k < len; k++) {
                            if ((dp[i][j][k] && dp[i + k][j + k][len - k]) || (dp[i][len - k + j][k] && dp[i + k][j][len - k])){
                                dp[i][j][len] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0][n];
    }

}
