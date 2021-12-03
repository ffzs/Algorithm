package largestSumAfterKNegations;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/12/3 上午8:00
 */
public class Solution {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length && nums[i] < 0 && k > 0 ) {
            nums[i] = -nums[i];
            k--;
            i++;
        }
        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }

        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }

}
