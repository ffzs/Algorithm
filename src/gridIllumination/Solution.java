package gridIllumination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2022/2/8 上午8:43
 * 01, 12, 23, 34  x1 - y1 = x2 - y2, x1 - x2 = y1 - y2
 * 03, 12, 21, 30 x1 + y1 = x2 + y2, x1 - x2 = y2 - y1
 * x1 - x2 = +-(y1 - y2) || x1 == x2 || y1 == y2
 */
public class Solution {
    long n;
    Map<Integer, Integer> row, col, xy, yx;
    Set<Long> set;
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        this.n = n;
        row = new HashMap<>();
        col = new HashMap<>();
        xy = new HashMap<>();
        yx = new HashMap<>();
        set = new HashSet<>();
        for (int[] lamp : lamps) inputLamp(lamp[0], lamp[1]);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (isOn(x, y)) res[i] = 1;
            turnOff(x,y);
        }
        return res;
    }

    private void turnOff(int x, int y) {
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (!isValid(i,j)) continue;
                if (set.remove(getIndex(i,j))) removeLamp(i,j);
            }
        }
    }

    private boolean isOn (int x, int y) {
        return row.containsKey(x) || col.containsKey(y) || xy.containsKey(x - y) || yx.containsKey(x + y);
    }

    private boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<n && y<n;
    }

    private void removeLamp(int x, int y) {
        if (row.get(x) <= 1) row.remove(x);
        else row.put(x, row.get(x)-1);
        if (col.get(y) <= 1) col.remove(y);
        else col.put(y, col.get(y)-1);
        if (xy.get(x-y) <= 1) xy.remove(x-y);
        else xy.put(x-y, xy.get(x-y)-1);
        if (yx.get(x+y) <= 1) yx.remove(x+y);
        else yx.put(x+y, yx.get(x+y)-1);
    }

    private void inputLamp(int x, int y) {
        if (set.contains(getIndex(x,y))) return;
        set.add(getIndex(x, y));
        row.put(x, row.getOrDefault(x, 0) + 1);
        col.put(y, col.getOrDefault(y, 0) + 1);
        xy.put(x-y, xy.getOrDefault(x-y, 0) + 1);
        yx.put(x+y, yx.getOrDefault(x+y, 0) + 1);
    }

    private long getIndex(int x, int y) {
        return x * n + y;
    }

}
