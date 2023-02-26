package movesToMakeZigzag;

/**
 * @author: ffzs
 * @Date: 2023/2/27 上午6:41
 */
public class Solution {

    public int movesToMakeZigzag(int[] nums) {
        return Math.min(helper(nums, 0), helper(nums, 1));
    }

    private int helper (int[] nums, int idx) {
        int ret = 0;
        for (int i = idx; i < nums.length; i+=2) {
            int a = 0;
            if (i - 1 >= 0 && nums[i-1]<=nums[i]) {
                a = nums[i] - nums[i-1] + 1;
            }
            if (i + 1 < nums.length && nums[i+1] <= nums[i]) {
                a = Math.max(a, nums[i] - nums[i+1] + 1);
            }
            ret += a;
        }
        return ret;
    }

}
