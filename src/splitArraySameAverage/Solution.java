package splitArraySameAverage;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/11/14 上午9:44
 */
public class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] cSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cSum[i + 1] = cSum[i] + nums[i];
        }

        for (int i = 1; i <= n / 2; i++) {
            if ((cSum[n] * i) % n == 0 && dfs(nums, cSum, n, i, (cSum[n] * i) / n)) return true;
        }
        return false;
    }

    private boolean dfs (int[] nums, int[] cSum, int idx, int k, int target) {
        if (k == 1) {
            for (int i = idx-1; i >= 0; i--) {
                if (nums[i] == target) return true;
                if (nums[i] < target) return false;
            }
        }
        for (int i = idx; cSum[i] - cSum[i - k] >= target;) {
            i -= 1;
            if (cSum[k-1] > target - nums[i]) continue;
            if (dfs(nums, cSum, i, k-1, target - nums[i])) return true;
        }
        return false;
    }

}
