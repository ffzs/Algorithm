package countVowelPermutation;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/1/17 上午8:42
 */
public class Solution {
    int MOD = (int)1e9 + 7;
    public int countVowelPermutation(int n) {
        long[][] dp = new long[2][5];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            int a = (i & 1), b = (i + 1) & 1;
            dp[a][0] = dp[b][1];
            dp[a][1] = dp[b][0] + dp[b][2];
            dp[a][2] = dp[b][0] + dp[b][1] + dp[b][3] + dp[b][4];
            dp[a][3] = dp[b][2] + dp[b][4];
            dp[a][4] = dp[b][0];
            for (int j = 0; j < 5; j++) {
                dp[a][j] %= MOD;
            }
        }

        long res = 0;
        for (int i = 0; i < 5; i++) {
            res += dp[(n-1) & 1][i];
        }
        return (int)(res % MOD);
    }

}
