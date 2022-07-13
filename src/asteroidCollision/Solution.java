package asteroidCollision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/7/13 上午8:20
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] tmp = new int[n];
        int idx = -1;
        for (int i = 0; i < n; i++) {
            int cur = asteroids[i];
            if (idx != -1 && tmp[idx] > 0 && cur < 0) {
                if (tmp[idx] > -cur) continue;
                else if (tmp[idx] < -cur) i -= 1;
                idx -= 1;
            }
            else tmp[++idx] = cur;
        }
        return Arrays.copyOfRange(tmp, 0, idx + 1);
    }
    public int[] asteroidCollision2(int[] asteroids) {
        int n = asteroids.length;

        for (int i = 0; i < n; i++) {
            if (asteroids[i] < 0) {
                for (int j = i-1; j >= 0; j--) {
                    if (asteroids[j] <= 0) continue;
                    if (asteroids[j] < -asteroids[i]) {
                        asteroids[j] = 0;
                    }
                    else if (asteroids[j] == -asteroids[i]) {
                        asteroids[j] = 0;
                        asteroids[i] = 0;
                        break;
                    }
                    else {
                        asteroids[i] = 0;
                        break;
                    }
                }
            }
        }

        int len = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) len += 1;
        }
        int[] res = new int[len];
        int i = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) res[i++] = asteroid;
        }
        return res;
    }

}
