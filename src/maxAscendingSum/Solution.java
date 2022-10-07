package maxAscendingSum;

/**
 * @author: ffzs
 * @Date: 2022/10/7 下午3:03
 */
public class Solution {

    public int maxAscendingSum(int[] nums) {
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i-1] < nums[i]) sum += nums[i];
            else {
                res = Math.max(sum, res);
                sum = nums[i];
            }
        }
        return Math.max(sum, res);
    }

}
