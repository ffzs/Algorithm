package wiggleMaxLength;

/**
 * @author: ffzs
 * @Date: 2020/12/12 上午10:14
 */

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int top = 1, bottom = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) top = bottom + 1;
            else if (nums[i] < nums[i-1]) bottom = top + 1;
        }

        return Math.max(top, bottom);
    }
}
