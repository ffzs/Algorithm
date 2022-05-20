package findRightInterval;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/5/20 上午8:39
 */
public class Solution {

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] tmp = new int[n][2];

        for (int i = 0; i < n; i++) {
            tmp[i] = new int[]{intervals[i][0], i};
        }

        Arrays.sort(tmp, (a, b) -> a[0] - b[0]);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (intervals[i][1] > tmp[n-1][0]) res[i] = -1;
            else res[i] = findStart(tmp, intervals[i][1]);
        }

        return res;
    }

    private int findStart (int[][] tmp, int aim) {
        int l = 0, r = tmp.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (tmp[mid][0] < aim) l = mid + 1;
            else r = mid;
        }
        return tmp[l][1];
    }

}
