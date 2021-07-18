package maxFrequency;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/7/19 上午6:53
 */
public class Solution {

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int l = 0;
        int res = 1;
        long sum = 0L;
        for (int r = 1; r < n; r++) {
            sum += (nums[r] - nums[r - 1]) * (r - l);
            while (sum > k) {
                sum -= nums[r] - nums[l++];
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}
