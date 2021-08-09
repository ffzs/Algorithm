package numberOfArithmeticSlices;

/**
 * @author: ffzs
 * @Date: 2021/8/10 上午6:58
 */
public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int res = 0;
        int diff = nums[0] - nums[1];
        int cnt = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i - 1] - nums[i] == diff) cnt ++;
            else {
                diff = nums[i - 1] - nums[i];
                cnt = 0;
            }
            res += cnt;
        }
        return res;
    }

}
