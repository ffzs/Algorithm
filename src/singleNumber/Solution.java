package singleNumber;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/4/30 下午12:21
 */
public class Solution {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        if (n == 1 || nums[0] != nums[1]) return nums[0];

        for (int i = 1; i < n-1; i++) {
            if(nums[i-1] != nums[i] && nums[i] != nums[i+1]) return nums[i];
        }

        return nums[n-1];
    }

}
