package insert;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/4 上午8:48
 */
public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        int[] left = new int[0];
        int[] right = new int[0];
        for (int[] interval : intervals) {
            if (newInterval[0]>=interval[0] && newInterval[0] <= interval[1]) left = interval;
            if (newInterval[1]>=interval[0] && newInterval[1] <= interval[1]) right = interval;
        }

        int[][] res = new int[intervals.length+1][2];
        int i = 0, count = 0;
        if (left.length == 0 && right.length == 0) {
            for (int[] interval : intervals) {
                if (newInterval[1] < interval[0]) {
                    res[i++] = newInterval;
                }
                res[i++] = interval;
            }
            if (i != res.length) res[i] = newInterval;
        }
        else {
            int[] newI;
            if (left.length == 0) {
                newI = new int[]{newInterval[0], right[1]};
            }
            else if (right.length == 0) {
                newI = new int[]{left[0], newInterval[1]};
            }
            else {
                newI = new int[]{left[0], right[1]};
            }
            for (int[] interval : intervals) {
                if (interval[1] < newI[0] || interval[0] > newI[1]) {
                    res[i++] = interval;
                    count++;
                }
                else if (i == 0 || res[i-1] != newI) {
                        res[i++] = newI;
                        count++;
                }
            }
            res = Arrays.copyOf(res, count);
        }

        return res;
    }

}
