package numSubarrayProductLessThanK;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/5/5 上午8:39
 */
public class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int prod = 1, l = 0, r = 0;
        while (r < nums.length) {
            prod *= nums[r];
            while (l <= r && prod >= k) prod /= nums[l++];
            res += r - l + 1;
            ++r;
        }

        return res;
    }

}
