package preimageSizeFZF;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/8/28 上午9:15
 * 5 ^ 1  0  0
 * 5 ^ 2  1  1
 * 5 ^ 3  25 * 5  1 * 5 + 1 = 6
 * 5 ^ 4  125 * 5  6 * 5 + 1 = 31
 * 124 / 5 = 24 24 / 5 = 4 -> 124 / 25 = 4 4 * 1 +
 */
public class Solution {

    static int[][] tmp;
    static {
        int n = 1;
        for (int i = 5; i < 1000000000; i*=5) n += 1;
        tmp = new int[n + 1][3];
        tmp[1] = new int[]{5, 0, 1};
        for (int i = 2; i < tmp.length; i++) {
            tmp[i][0] = tmp[i-1][0] * 5;
            tmp[i][1] = tmp[i-1][1] * 5 + 1;
            tmp[i][2] = tmp[i-1][0] + tmp[i][1];
        }
    }
    public int preimageSizeFZF(int k) {
        int n = tmp.length, r;
        for (int i = n-1; i >= 1; i--) {
            if (k < tmp[i][2]) continue;
            r = k / tmp[i][2];
            k = k % tmp[i][2];
            if (k > tmp[i][2] - i || k == 5 || r == 5) return 0;
            if (k == 0) return 5;
        }
        return 5;
    }

    private int f(int x) {
        int n = 0, t = x;
        while (t / 5 != 0) {
            t /= 5;
            n += 1;
        }
        return x / 5 + tmp[n][1] * t;
    }

}
