package longestAlternatingSubarray;

/**
 * @author: ffzs
 * @Date: 2023/11/16 上午11:23
 */
public class Solution {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n && (n-i) > res; i++) {

            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int r = i + 1;
                while (r < n && nums[r-1] % 2 != nums[r] % 2 && nums[r] <= threshold) r++;
                res = Math.max(res, r - i);
            }
        }
        return res;
    }

}
