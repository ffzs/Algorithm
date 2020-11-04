package insert;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/4 上午9:58
 */
public class Solution2 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};

        for (int[] interval : intervals) {
            if (newInterval[0]>=interval[0] && newInterval[0] <= interval[1]) newInterval[0] = interval[0];
            if (newInterval[1]>=interval[0] && newInterval[1] <= interval[1]) newInterval[1] = interval[1];
        }

        int[][] res = new int[intervals.length+1][2];
        int i = 0;
        boolean flag = false;
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                res[i++] = interval;
            }
            else if (!flag && (i == 0 || res[i-1] != newInterval)) {
                res[i++] = newInterval;
                flag = true;
            }
            if (interval[0] > newInterval[1]) {
                res[i++] = interval;
            }
        }

        if (!flag) res[i++] = newInterval;
        res = Arrays.copyOf(res, i);

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,5}};
        int[] newInterval = {0,0};
        System.out.println(Arrays.deepToString(solution.insert(intervals, newInterval)));
    }
}
