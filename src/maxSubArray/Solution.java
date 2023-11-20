package maxSubArray;

/**
 * @author: ffzs
 * @Date: 2023/11/20 上午9:47
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int sum = 0, res = nums[0];

        for (int num : nums) {
            sum = sum >= 0 ? sum + num : num;
            res = Math.max(res, sum);
        }

        return res;
    }
}
