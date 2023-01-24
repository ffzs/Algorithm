package countPoints;

/**
 * @author: ffzs
 * @Date: 2023/1/24 上午9:04
 */
public class Solution {

    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int x = queries[i][0], y = queries[i][1], r = queries[i][2], cnt = 0;
            for (int[] point : points) {
                if ((x - point[0]) * (x - point[0]) + (y - point[1]) * (y - point[1]) <= r * r) cnt += 1;
            }
            res[i] = cnt;
        }
        return res;
    }

}
