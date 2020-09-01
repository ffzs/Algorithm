package PredictTheWinner;

/**
 * @author: ffzs
 * @Date: 2020/9/1 上午8:37
 */

public class Solution2 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        // 先填上分界线
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];
        // 因为要获得 ij ,因此需要优先获取i+1,j-1等，所以从后向前获取
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = Math.max((nums[i] - dp[i+1][j]), (nums[j] - dp[i][j-1]));
            }
        }
        return dp[0][n-1] >= 0;
    }
}
