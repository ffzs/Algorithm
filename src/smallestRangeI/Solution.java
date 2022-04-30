package smallestRangeI;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/4/30 上午8:30
 */
public class Solution {

    public int smallestRangeI(int[] nums, int k) {
        if (nums.length == 1) return 0;
        int maxV = nums[0], minV = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxV) maxV = nums[i];
            else if (nums[i] < minV) minV = nums[i];
        }

        return Math.max(0, (maxV - minV) - 2 * k);
    }

}
