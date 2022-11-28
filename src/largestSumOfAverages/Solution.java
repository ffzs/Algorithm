package largestSumOfAverages;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/11/28 下午7:45
 */
public class Solution {

    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] cumSums = new double[n + 1];
        for (int i = 0; i < n; i++) {
            cumSums[i + 1] = cumSums[i] + nums[i];
        }

        double[][] dp = new double[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][1] = cumSums[i] / i;
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                for (int l = j - 1; l < i; l++) {
                    dp[i][j] = Math.max(dp[i][j], dp[l][j - 1] + (cumSums[i] - cumSums[l])/(i - l));
                }
            }
        }

        return dp[n][k];
    }

}
