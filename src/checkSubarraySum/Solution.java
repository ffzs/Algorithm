package checkSubarraySum;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/6/2 上午7:32
 */
public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] tmp = new int[n + 1];
        for (int i = 1; i <= nums.length; i++) {
            tmp[i] = tmp[i - 1] + nums[i];
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 2; j < n+1; j++) {
                if ((tmp[j] - tmp[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
