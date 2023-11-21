package minDeletion;

/**
 * @author: ffzs
 * @Date: 2023/11/21 下午6:52
 */
public class Solution {

    public int minDeletion(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int res = 0;
        while (i < n) {
            j = i + 1;
            while (j < n && nums[j] == nums[i]) {
                j += 1;
                res += 1;
            }

            i = j + 1;
        }
        if ((n - res) % 2 == 0) return res;
        return res + 1;
    }

}
