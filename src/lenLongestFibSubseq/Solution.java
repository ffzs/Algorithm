package lenLongestFibSubseq;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2022/7/9 上午8:22
 */
public class Solution {

    public int lenLongestFibSubseq(int[] arr) {
        int res = 0, n = arr.length;
        int[][] cnt = new int[n][n];
        int val;

        for (int i = 2; i < n; i++) {
            int it = arr[i], l = 0, r = i - 1;
            while (l < r) {
                val = arr[l] + arr[r];
                if (val > it) {
                    r -= 1;
                }
                else if (val < it) l += 1;
                else {
                    res = Math.max(res, cnt[i][r] = cnt[r][l] + 1);
                    r -= 1;
                    l += 1;
                }
            }
        }
        return res == 0 ? 0 : res + 2;
    }

}
