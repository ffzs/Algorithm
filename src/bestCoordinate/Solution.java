package bestCoordinate;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/11/2 下午7:37
 */
public class Solution {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int mx = 0, my = 0;
        for (int[] tower : towers) {
            mx = Math.max(mx, tower[0]);
            my = Math.max(my, tower[1]);
        }
        int rx = 0, ry = 0, maxValue = 0, rq = radius * radius;
        for (int x = 0; x <= mx; x++) {
            for (int y = 0; y <= my; y++) {
                int value = 0;
                for (int[] tower : towers) {
                    int distance = getDistance(x, y, tower[0], tower[1]);
                    if (distance <= rq) {
                        value += (int)(tower[2] / (1 + Math.sqrt(distance)));
                    }
                }
                if (value > maxValue) {
                    maxValue = value;
                    rx = x;
                    ry = y;
                }
            }
        }
        return new int[]{rx, ry};
    }
    private int getDistance (int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

}
