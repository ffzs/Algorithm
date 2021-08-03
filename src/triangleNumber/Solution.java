package triangleNumber;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/8/4 上午6:53
 */
public class Solution {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int k = i + 1;
            for (int j = i + 1; j < n; j++) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) k++;
                res += Math.max(k - j, 0);
            }
        }
        return res;
    }
}
