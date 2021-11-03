package trapRainWater;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2021/11/3 上午7:23
 */
public class Solution {
    static int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) return 0;

        int n = heightMap.length;
        int m = heightMap[0].length;

        boolean[][] step = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n-1 || j == m-1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    step[i][j] = true;
                }
            }
        }

        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && !step[x][y]) {
                    if (cur[2] > heightMap[x][y]) res += cur[2] - heightMap[x][y];
                    pq.offer(new int[]{x, y, Math.max(heightMap[x][y], cur[2])});
                    step[x][y] = true;
                }
            }
        }
        return res;
    }

}
