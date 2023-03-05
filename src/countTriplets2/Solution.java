package countTriplets2;

/**
 * @author: ffzs
 * @Date: 2023/3/4 下午1:45
 */
public class Solution {

    public int countTriplets(int[] nums) {
        int res = 0;
        int[] cnt = new int[1 << 16];
        for (int i : nums) {
            for (int j : nums) {
                cnt[i & j] += 1;
            }
        }

        for (int num : nums) {
            int it = num ^ ((1 << 16) - 1);
            for (int sub = it; sub > 0; sub = (sub-1) & it) {
                res += cnt[sub];
            }
            res += cnt[0];
        }

        return res;
    }

}
