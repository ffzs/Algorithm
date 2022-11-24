package numSubarrayBoundedMax;

/**
 * @author: ffzs
 * @Date: 2022/11/24 下午1:53
 */
public class Solution {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, n = nums.length, l = 0;
        while (l < n) {
            if (nums[l] <= right) {
                int i = l + 1;
                while (i < n && nums[i] <= right) i += 1;
                res += helper(nums, l, i - 1, left);
                l = i;
            }
            l += 1;
        }
        return res;
    }

    private int helper (int[] nums, int l, int r, int limit) {
        long ret = count(l, r);
        while (l <= r) {
            if (nums[l] < limit) {
                int i = l + 1;
                while (i <= r && nums[i] < limit) i += 1;
                ret -= count(l, i - 1);
                l = i;
            }
            l += 1;
        }
        return (int)ret;
    }

    private long count (int l, int r) {
        return (long)(r - l + 2) * (r - l + 1) / 2;
    }

}
