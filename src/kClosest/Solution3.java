package kClosest;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/9 上午8:01
 */
public class Solution3 {

    public int[][] kClosest(int[][] points, int K) {

        int left = 0, right = points.length-1, cur = -1;
        while (cur != K - 1) {
            cur = quickSort(points, left, right);
            if (cur < K - 1) left = cur + 1;
            if (cur > K - 1) right = cur - 1;
        }
        return Arrays.copyOf(points, K);
    }

    private int quickSort(int[][] p, int l, int r) {
        int dis = dist(p[l]);
        while (l < r) {
            while (l < r && dist(p[r]) >= dis) r--;
            if (l < r) swap(p, l, r);
            while (l < r && dist(p[l]) <= dis) l++;
            if (l<r) swap(p, l ,r);
        }
        swap(p ,l, r);
        return l;
    }

    private int dist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }

    private void swap(int[][] p, int l, int r) {
        int[] tmp = p[l];
        p[l] = p[r];
        p[r] = tmp;
    }
}
