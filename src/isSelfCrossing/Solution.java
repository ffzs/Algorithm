package isSelfCrossing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/10/29 上午7:15
 */
public class Solution {
    public boolean isSelfCrossing(int[] d) {
        int n = d.length;
        if (n <= 3) return false;
        for (int i = 3; i < n; i++) {
            if (d[i] >= d[i-2] && d[i-1] <= d[i-3]) return true;
            if (i == 4 && (d[3] == d[1] && d[4] >= d[2] - d[0])) return true;
            if (i >= 5 && (d[i-3] - d[i-5] <= d[i-1] && d[i-1] <= d[i-3] && d[i] >= d[i-2] - d[i-4] && d[i-2] > d[i - 4])) return true;
        }
        return false;
    }
}
