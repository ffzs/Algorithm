package find132pattern;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ffzs
 * @Date: 2021/3/24 下午3:39
 */
public class Solution {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i-1], nums[i]);
        }

        for (int i = n - 1; i > 0; i--) {
            if (left[i] < nums[i] - 1 && check(nums, i, nums[i], left[i])) return true;
        }
        return false;
    }

    private boolean check (int[] nums, int i, int max, int min) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > min && nums[j] < max) return true;
        }
        return false;
    }

}
