package rob2;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/4/15 上午9:18
 */
public class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] pre = Arrays.copyOf(nums, n - 1);
        int[] suf = Arrays.copyOfRange(nums, 1, n);
        return Math.max(helper(pre), helper(suf));
    }

    private int helper(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= len; ++i) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[len];
    }
}
