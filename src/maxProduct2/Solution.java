package maxProduct2;

/**
 * @author: ffzs
 * @Date: 2022/8/26 上午9:56
 */
public class Solution {

    public int maxProduct(int[] nums) {
        int maxV = nums[0], second = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxV) {
                second = maxV;
                maxV = nums[i];
            }
            else if (nums[i] > second) second = nums[i];
        }
        return (maxV - 1) * (second - 1);
    }

}
