package minStartValue;

/**
 * @author: ffzs
 * @Date: 2022/8/9 上午8:26
 */
public class Solution {

    public int minStartValue(int[] nums) {
        int minV = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
            minV = Math.min(minV, nums[i]);
        }

        return 1 - Math.min(0, minV);
    }

}
