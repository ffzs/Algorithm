package findMinArrowShots;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ffzs
 * @Date: 2020/11/23 下午3:07
 */
public class Solution {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) return 1;
            else if (a[1] < b[1]) return -1;
            else return 0;
        });

        int start = points[0][1];
        int res = 1;
        for (int[] point : points) {
            if (point[0]>start) {
                start = point[1];
                res++;
            }
        }
        return res;
    }
}
