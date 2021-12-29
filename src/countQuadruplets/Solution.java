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
        int[] cnt = new int[101];

        for (int j = 1; j < n - 2; j++) {
            for (int i = 0; i < j; i++) {
                int k = nums[i] + nums[j];
                if (k < 101) ++cnt[k];
            }

            for (int l = j + 2; l < n; l++) {
                int k = nums[l] - nums[j + 1];
                if (k > 0 && k < 101) res += cnt[k];
            }
        }
        return res;
    }

}
