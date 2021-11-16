package isRectangleCover;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/11/16 上午7:24
 * 统计面积和是否相等
 * 如果面积和相等的话那么统计相交情况
 */
public class Solution {

    public boolean isRectangleCover(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        long area = 0;
        int minX = rectangles[0][0];
        int minY = rectangles[0][1];
        int maxX = rectangles[0][0];
        int maxY = rectangles[0][1];

        for (int[] rect : rectangles) {
            int x = rect[0], y = rect[1], a = rect[2], b = rect[3];
            area += (long)(a - x) * (b - y);

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, a);
            maxY = Math.max(maxY, b);

            int p1 = getKey(x, y);
            int p2 = getKey(x, b);
            int p3 = getKey(a, y);
            int p4 = getKey(a, b);

            map.put(p1, map.getOrDefault(p1, 0) + 1);
            map.put(p2, map.getOrDefault(p2, 0) + 1);
            map.put(p3, map.getOrDefault(p3, 0) + 1);
            map.put(p4, map.getOrDefault(p4, 0) + 1);
        }

        int p1 = getKey(minX, minY);
        int p2 = getKey(minX, maxY);
        int p3 = getKey(maxX, minY);
        int p4 = getKey(maxX, maxY);

        if (area != (long)(maxX - minX)*(maxY -minY) || map.getOrDefault(p1, 0) != 1 || map.getOrDefault(p2, 0) != 1 || map.getOrDefault(p3, 0) != 1|| map.getOrDefault(p4, 0) != 1) return false;

        map.remove(p1);
        map.remove(p2);
        map.remove(p3);
        map.remove(p4);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            if (v != 2 && v != 4) return false;
        }
        return true;
    }

    private int getKey (int x, int y) {
        return x * 200000 + y;
    }

}
