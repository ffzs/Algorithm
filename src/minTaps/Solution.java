package minTaps;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/2/21 上午6:31
 */
public class Solution {

    public int minTaps(int n, int[] ranges) {
        int[][] gaps = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            gaps[i] = new int[]{Math.max(0, i - ranges[i]), i + ranges[i]};
        }
        Arrays.sort(gaps, (a,b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        if (gaps[0][0] != 0) return -1;
        if (gaps[0][1] >= n) return 1;
        int res = 1, pre = gaps[0][1], maxV = gaps[0][1];
        for (int i = 1; i < gaps.length; i++) {
            if (gaps[i][0] == gaps[i-1][0]) continue;
            if (gaps[i][0] > pre) {
                if (gaps[i][0] > maxV) return -1;
                res += 1;
                pre = maxV;
            }
            if (gaps[i][0] <= pre) {
                maxV = Math.max(maxV, gaps[i][1]);
                if (maxV >= n) return res + 1;
            }
        }
        return res;
    }

}
