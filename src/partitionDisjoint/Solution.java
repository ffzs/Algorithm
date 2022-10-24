package partitionDisjoint;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/10/24 下午2:11
 */
public class Solution {

    public int partitionDisjoint(int[] nums) {
        int maxValue = nums[0], idx = 0, cutMaxValue = maxValue;
        for (int i = 1; i < nums.length - 1; i++) {
            cutMaxValue = Math.max(cutMaxValue, nums[i]);
            if (nums[i] < maxValue) {
                maxValue = cutMaxValue;
                idx = i;
            }
        }
        return idx + 1;
    }

}
