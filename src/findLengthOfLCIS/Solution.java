package findLengthOfLCIS;

/**
 * @author: ffzs
 * @Date: 2021/1/24 上午8:08
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0, counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                counter ++;
            }
            else {
                res = Math.max(res, counter);
                counter = 1;
            }
        }

        return Math.max(res, counter);
    }

}
