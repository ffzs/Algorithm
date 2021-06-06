package findTargetSumWays;

/**
 * @author: ffzs
 * @Date: 2021/6/7 上午7:04
 */
public class Solution2 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < target || (sum + target) % 2 == 1) return 0;

        int bg = (sum-target)/2;
        int[] dp = new int[bg+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = bg; i >= num; i--) {
                dp[i] = dp[i] + dp[i-num];
            }
        }
        return dp[bg];
    }

}
