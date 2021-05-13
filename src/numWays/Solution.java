package numWays;

/**
 * @author: ffzs
 * @Date: 2021/5/13 下午6:34
 */
public class Solution {

    public int numWays(int steps, int arrLen) {
        final int MODULE_ = 1000000000 + 7;
        int len = Math.min(arrLen - 1, steps);
        int[][] dp = new int[steps + 1][len + 3];
        dp[0][1] = 1;

        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= len; j++) {
                dp[i][j+1] = ((dp[i-1][j] + dp[i-1][j+1]) % MODULE_ + dp[i-1][j+2]) % MODULE_;
            }
        }
        return dp[steps][1];
    }
}
