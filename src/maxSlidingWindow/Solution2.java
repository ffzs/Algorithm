package maxSlidingWindow;

/**
 * @author: ffzs
 * @Date: 2021/1/2 下午4:40
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n -k + 1];
        int idx = 0, max = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > max || i %k == 0) max = nums[i];
            left[idx++] = max;
        }

        idx = n-1;
        max = nums[n-1];
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] > max || i%k == 0) max = nums[i];
            right[idx--] = max;
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(right[i], left[i+k-1]);
        }
        return res;
    }
}
