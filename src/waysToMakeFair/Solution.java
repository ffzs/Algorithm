package waysToMakeFair;

/**
 * @author: ffzs
 * @Date: 2023/1/28 上午10:02
 */
public class Solution {

    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int so = 0, se = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) so += nums[i];
            else se += nums[i];
        }

        int res = 0;
        int o = 0, e = 0;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            if ((i & 1) == 1) {
                if (o + (se - e) == e + (so - o - v)) res += 1;
                o += v;
            }
            else {
                if (o + (se - e - v) == e + (so - o)) res += 1;
                e += v;
            }
        }
        return res;
    }

}
