package countQuadruplets;

/**
 * @author: ffzs
 * @Date: 2021/12/29 上午7:59
 */
public class Solution {

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        if (n <= 3) return 0;
        int res = 0;
        int[] cnt = new int[100*3 + 1];

        for (int i = 2; i < n; ++i) {
            res += cnt[nums[i]];
            for (int j = i-1; j > 0; --j) {
                for (int k = j-1; k >= 0; --k) {
                    ++cnt[nums[i] + nums[j] + nums[k]];
                }
            }
        }
        return res;
    }

}
