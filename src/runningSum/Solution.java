package runningSum;

/**
 * @author: ffzs
 * @Date: 2021/8/28 上午7:10
 */
public class Solution {

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }

}
