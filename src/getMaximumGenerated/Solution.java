package getMaximumGenerated;

/**
 * @author: ffzs
 * @Date: 2021/8/23 上午6:51
 */
public class Solution {

    public int getMaximumGenerated(int n) {
        if (n <= 1) return n;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int i = 1;
        while (i * 2 <= n) {
            nums[i*2] = nums[i];
            if ( i*2+1 <= n) nums[i*2+1] = nums[i] + nums[i + 1];
            i++;
        }
        int res = 0;
        for (int num : nums) {
            res = Math.max(num, res);
        }
        return res;
    }

}
