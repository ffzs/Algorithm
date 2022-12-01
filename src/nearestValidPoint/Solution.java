package nearestValidPoint;

/**
 * @author: ffzs
 * @Date: 2022/12/1 下午12:15
 */
public class Solution {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1, minDistance = Integer.MAX_VALUE >> 1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x) {
                if (Math.abs(point[1] - y) < minDistance) {
                    res = i;
                    minDistance = Math.abs(point[1] - y);
                }
            }
            if (point[1] == y) {
                if (Math.abs(point[0] - x) < minDistance) {
                    res = i;
                    minDistance = Math.abs(point[0] - x);
                }
            }
        }
        return res;
    }

}
