package check;

/**
 * @author: ffzs
 * @Date: 2022/11/27 下午9:08
 */
public class Solution {

    public boolean check(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt += 1;
                if (cnt > 1) return false;
            }
        }
        return cnt == 0 || nums[nums.length-1] <= nums[0];
    }
}
