package maximumProduct;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/1/20 上午8:28
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 1;
        for (int i = 1; i < 4; i++) {
            res *= nums[n-i];
        }
        return Math.max(res, nums[0]*nums[1]*nums[n-1]);
    }
}
