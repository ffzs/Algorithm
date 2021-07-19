package minPairSum;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/7/20 上午6:56
 */
public class Solution {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxSum = 0;
        for (int i = 0; i < n/2; i++) {
            maxSum = Math.max(maxSum, nums[i] + nums[n-1-i]);
        }
        return maxSum;
    }

}
