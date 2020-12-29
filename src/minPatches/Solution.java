package minPatches;

/**
 * @author: ffzs
 * @Date: 2020/12/29 下午7:30
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        long total = 1;
        int res = 0, i = 0;
        while (total <= n) {
            if (i < nums.length && nums[i] <= total) {
                total += nums[i++];
            }else {
                total *= 2;
                res ++;
            }
        }
        return res;
    }
}
