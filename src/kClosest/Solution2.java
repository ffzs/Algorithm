package kClosest;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/9 上午7:45
 */
public class Solution2 {

    public int[][] kClosest(int[][] points, int K) {

        int[] tmp = new int[points.length];
        int[][] res = new int[K][2];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = dist(points[i]);
        }
        Arrays.sort(tmp);
        int i = 0;
        for (int[] point : points) {
            if (dist(point) <= tmp[K-1]) {
                res[i++] = point;
            }
            if (i == K) break;
        }
        return res;
    }

    private int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

}
