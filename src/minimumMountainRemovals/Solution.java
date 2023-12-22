package minimumMountainRemovals;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/12/22 上午8:35
 */
public class Solution {

    public int minimumMountainRemovals(int[] nums) {
        int res = 0, n = nums.length;
        int[] pre = helper(nums);
        reverse(nums);
        int[] suf = helper(nums);
        reverse(suf);

        for (int i = 0; i < n; i++) {
            if (pre[i] > 1 && suf[i] > 1) {
                res = Math.max(res, pre[i] + suf[i] - 1);
            }
        }
        return n - res;
    }

    private int[] helper(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }

}
