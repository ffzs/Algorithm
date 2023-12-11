package minimumEffortPath2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2023/12/11 上午8:40
 */
public class Solution {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int m, n;
    int INF = Integer.MAX_VALUE >> 1;
    public int minimumEffortPath(int[][] heights) {

        m = heights.length;
        n = heights[0].length;

        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int[] ints : dist) {
            Arrays.fill(ints, INF);
        }

        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[2]-b[2]);

        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], d = cur[2];
            if (x == m - 1 && y == n - 1) break;
            if (visited[x][y]) continue;

            visited[x][y] = true;

            for (int[] dir : dirs) {
                int xx = dir[0] + x, yy = dir[1] + y;
                if (isValid(xx, yy)) {
                    int dd = Math.max(d, Math.abs(heights[x][y] - heights[xx][yy]));
                    if (dd < dist[xx][yy]) {
                        dist[xx][yy] = dd;
                        pq.offer(new int[]{xx, yy, dd});
                    }
                }
            }
        }

        return dist[m-1][n-1];

    }

    private boolean isValid (int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
