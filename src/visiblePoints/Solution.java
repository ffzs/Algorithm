package visiblePoints;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/12/16 上午7:30
 */
public class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int lCnt = 0, n = points.size();
        int lx = location.get(0), ly = location.get(1);

        double[] angles = new double[2 * n];
        Arrays.fill(angles, Double.MAX_VALUE);
        int idx = 0;
        for (List<Integer> point : points) {
            int x = point.get(0), y = point.get(1);
            if (x == lx && y == ly) {
                lCnt++;
                continue;
            }
            angles[idx++] = Math.atan2(y - ly, x - lx);
        }

        Arrays.sort(angles);
        int m = idx;
        for (int i = 0; i < m; i++) {
            angles[idx++] = angles[i] + 2 * Math.PI;
        }


        int res = 0;
        int l = 0, r = 0;
        double pa = angle * Math.PI / 180;
        while ( l < idx && r < idx) {
            while (r < idx && angles[r] - angles[l] <= pa) r++;
            res = Math.max(res, r - l);
            l++;
        }

        return res + lCnt;
    }

}


class Test {
    public static void main(String[] args) {
        System.out.println(Math.atan(0)*180/Math.PI);
    }
}