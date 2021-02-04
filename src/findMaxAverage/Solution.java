package findMaxAverage;

/**
 * @author: ffzs
 * @Date: 2021/2/4 上午8:51
 */
public class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, max;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i-k];
            max = Math.max(max, sum);
        }

        return (double)max/k;
    }

}
