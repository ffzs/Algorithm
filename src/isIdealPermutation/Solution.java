package isIdealPermutation;

/**
 * @author: ffzs
 * @Date: 2022/11/16 下午2:27
 */
public class Solution {

    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, m = n;
        for (int i = n-1; i >= 2; --i) {
            m = Math.min(nums[i], m);
            if (nums[i - 2] > m) return false;
        }
        return true;
    }

}
