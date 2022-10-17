package totalFruit;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/10/17 下午6:38
 */
public class Solution {

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] cnt = new int[n];
        int l = 0, r = 0;
        int types = 0, res = 0;
        while (l <= r && r < n) {
            while (r < n) {
                int num = fruits[r];
                if (cnt[num] == 0) types += 1;
                if (types > 2) {
                    types -= 1;
                    break;
                }
                cnt[num] += 1;
                r += 1;
            }
            res = Math.max(res, r - l);
            if (r == n) break;
            while (l <= r && types >= 2) {
                int num = fruits[l];
                cnt[num] -= 1;
                if (cnt[num] == 0) types -= 1;
                l += 1;
            }

        }
        return res;
    }
}
