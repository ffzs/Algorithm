package minimumDifference;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/2/11 上午9:05
 */
public class Solution {

    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 100_000;
        for (int i = 0; i < n - k + 1; i++) {
            res = Math.min(nums[i + k - 1] - nums[i], res);
        }
        return res;
    }

}
