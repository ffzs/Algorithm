package find132pattern;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2021/3/24 下午4:35
 */
public class Solution2 {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i-1], nums[i]);
        }

        Deque<Integer> stack = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n-1; i > 0; i--) {
            if (nums[i] > left[i] + 1) {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    max = stack.pop();
                }
                if (left[i] < max) return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
