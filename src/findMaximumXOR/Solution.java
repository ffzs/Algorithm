package findMaximumXOR;

/**
 * @author: ffzs
 * @Date: 2021/5/16 上午8:21
 */
public class Solution {

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, nums[i]^nums[j]);
            }
        }

        return res;
    }

}
