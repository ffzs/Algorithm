package eraseOverlapIntervals;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/12/31 上午8:10
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        int res = 0, i = 0;
        for (int j = 1; j < n; j++) {
            if (intervals[i][1] > intervals[j][0]) {
                res ++;
                i = intervals[i][1] < intervals[j][1] ? i : j;
            }
            else i = j;
        }
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        int[][] intervals = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}
