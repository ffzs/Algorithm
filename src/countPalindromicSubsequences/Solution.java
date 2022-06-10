package countPalindromicSubsequences;

/**
 * @author: ffzs
 * @Date: 2022/6/10 下午7:30
 */
public class Solution {
    public int countPalindromicSubsequences(String s) {
        int MOD =  (int)1e9 + 7;
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[][] dp =  new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;
                if (cs[i] == cs[j]) {
                    int l = i + 1, r = j - 1;
                    while (l <= r && cs[l] != cs[i]) ++l;
                    while (l <= r && cs[r] != cs[j]) --r;
                    if (l > r) dp[i][j] = dp[i+1][j-1] * 2 + 2;
                    else if (l == r) dp[i][j] = dp[i+1][j-1] * 2 + 1;
                    else dp[i][j] = dp[i+1][j-1] * 2 - dp[l+1][r-1];
                }
                else dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                if (dp[i][j] < 0) dp[i][j] += MOD;
                if (dp[i][j] >= MOD) dp[i][j] %= MOD;
            }
        }
        return dp[0][n-1];
    }
}
