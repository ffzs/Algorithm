package intersectionSizeTwo;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/7/22 上午11:43
 */
public class Solution {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int a = intervals[0][1] - 1;
        int b = intervals[0][1];

        int res = 2;
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            if (a == l && r == b) continue;
            if (l > b) {
                res += 2;
                a = r - 1;
                b = r;
            }
            else if (l == b || l > a) {
                res += 1;
                a = b;
                b = r;
            }
        }
        return res;
    }

}
