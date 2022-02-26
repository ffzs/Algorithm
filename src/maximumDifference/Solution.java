package maximumDifference;

/**
 * @author: ffzs
 * @Date: 2022/2/26 上午8:06
 */
public class Solution {
    int res = -1;
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int res = -1, min = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] == min) continue;
            if (nums[i] <= min) min = nums[i];
            else res = Math.max(res, nums[i] - min);
        }
        return res;
    }

}
