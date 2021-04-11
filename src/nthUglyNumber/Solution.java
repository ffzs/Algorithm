package nthUglyNumber;

/**
 * @author: ffzs
 * @Date: 2021/4/11 上午8:37
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int i = 1, j = 1, k = 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int l = 2; l < n+1; l++) {
            dp[l] = Math.min(dp[i]*2, Math.min(dp[j]*3, dp[k]*5));
            if (dp[l] == dp[i]) i++;
            if (dp[l] == dp[j]) j++;
            if (dp[l] == dp[k]) k++;
        }
        return dp[n];
    }
}
