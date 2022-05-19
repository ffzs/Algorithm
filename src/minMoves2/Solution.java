package minMoves2;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/5/19 上午8:40
 */
public class Solution {

    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return helper(nums, nums[n/2]);
    }

    private int helper (int[] nums, int aim) {
        int ret = 0;
        for (int num : nums) {
            ret += Math.abs(num - aim);
        }
        return ret;
    }

}
