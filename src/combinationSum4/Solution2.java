package combinationSum4;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/4/24 上午11:50
 */
public class Solution2 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.sort(nums);
        dp[0] = 1;
        for (int i = nums[0]; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}
