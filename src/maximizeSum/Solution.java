package maximizeSum;

/**
 * @author: ffzs
 * @Date: 2023/11/15 下午12:31
 */
public class Solution {

    public int maximizeSum(int[] nums, int k) {
        int maxV = nums[0];
        for (int num : nums) {
            maxV = Math.max(num, maxV);
        }

        return (maxV + maxV + k - 1) * k / 2;
    }

}
