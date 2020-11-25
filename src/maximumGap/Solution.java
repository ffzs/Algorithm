package maximumGap;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/26 上午7:23
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i]-nums[i-1], max);
        }
        return max;
    }
}
