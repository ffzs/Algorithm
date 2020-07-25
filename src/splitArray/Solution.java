package splitArray;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/7/25 上午8:09
 */
public class Solution {
    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i < n; ++i) nums[i] += nums[i-1];
        for (int i = 0; i < n + 1; ++i) Arrays.fill(dp[i], nums[n-1]);

        dp[0][0] = 0;
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j <= Math.min(i, m); ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < i; ++k) {
                    int nk = k==0? 0: nums[k-1];
                    min = Math.min(min, Math.max(dp[k][j-1], nums[i-1]-nk));
                }
                dp[i][j] = min;
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums, 2));
    }
}
