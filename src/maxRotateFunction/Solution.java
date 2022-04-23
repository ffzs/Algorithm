package maxRotateFunction;

/**
 * @author: ffzs
 * @Date: 2022/4/22 上午8:19
 */
public class Solution {

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0, f0 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            f0 += nums[i] * i;
        }

        int max = f0, cur = f0;
        for (int i = n - 1; i > 0; i--) {
            cur =  cur + sum - nums[i] * n;
            max = Math.max(max, cur);
        }

        return max;
    }

}
