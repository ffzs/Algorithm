package sumSubseqWidths;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/11/18 下午7:36
 */
public class Solution {
    static final int MOD = (int)1e9 + 7;
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long pow2 = 2, res = nums[0] - nums[n-1];
        for (int i = 1; i < n; i++) {
            int j = n - 1 - i;
            res = (res + (nums[i] - nums[j]) * pow2) % MOD;
            pow2 = pow2 * 2 % MOD;
        }
        return (int)((res + MOD) % MOD);
    }

}
