package maxPoints;

import kotlin.reflect.jvm.internal.impl.resolve.constants.PrimitiveTypeUtilKt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/6/24 上午7:05
 */
public class Solution {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res >= n - i || res > n / 2) break;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                if (x == 0) y = 1;
                else if (y == 0) x = 1;
                else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }

                    int g = gcd(Math.abs(x), Math.abs(y));

                    x /= g;
                    y /= g;
                }

                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                res = Math.max(res, e.getValue() + 1);
            }
        }
        return res;
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }


    public int maxPoints2(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res >= n - i || res > n / 2) break;
            for (int j = i + 1; j < n; j++) {
                int cnt = 2;
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                for (int k = j + 1; k < n; k++) {
                    if (((points[i][0] - points[k][0]) * y) == (points[i][1] - points[k][1]) * x ) cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
