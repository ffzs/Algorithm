package largestNumber2;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/6/12 上午7:19
 */
public class Solution {

    public String largestNumber(int[] cost, int target) {

        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) dp[i] = Integer.MIN_VALUE;

        for (int i = 1; i <= 9; i++) {
            int c = cost[i-1];
            for (int j = c; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - c] + 1);
            }
        }

        if (dp[target] < 0) return "0";
        StringBuilder res = new StringBuilder();

        for (int i = 9, j = target; i >= 1; i--) {
            int c = cost[i -1];
            while (j >= c && dp[j] == dp[j-c] + 1) {
                res.append(i);
                j -= c;
            }
        }
        return res.toString();
    }

}
