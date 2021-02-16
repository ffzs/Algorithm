package arrayPairSum;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/2/16 上午9:08
 */
public class Solution {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += nums[i*2];
        }
        return res;
    }

}
