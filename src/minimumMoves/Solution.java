package minimumMoves;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2023/2/5 下午9:55
 */
public class Solution {

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[][][] dist = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        dist[0][0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], direction = cur[2];
            if (direction == 0) {
                if (y + 2 < n && grid[x][y+2] == 0 && dist[x][y+1][0] == -1) {
                    dist[x][y+1][0] = dist[x][y][0] + 1;
                    q.offer(new int[] {x, y + 1, 0});
                }
                if (x + 1 < n && grid[x + 1][y] == 0 && grid[x+1][y+1] == 0) {
                    if (dist[x+1][y][0] == -1) {
                        dist[x+1][y][0] = dist[x][y][0] + 1;
                        q.offer(new int[]{x+1, y, 0});
                    }
                    if (dist[x][y][1] == -1) {
                        dist[x][y][1] = dist[x][y][0] + 1;
                        q.offer(new int[]{x, y , 1});
                    }
                }
            }
            else {
                if (x + 2 < n && grid[x+2][y] == 0 && dist[x+1][y][1] == -1) {
                    dist[x+1][y][1] = dist[x][y][1] + 1;
                    q.offer(new int[] {x + 1, y, 1});
                }
                if (y + 1 < n && grid[x][y+1] == 0 && grid[x + 1][y + 1] == 0) {
                    if (dist[x][y+1][1] == -1) {
                        dist[x][y+1][1] = dist[x][y][1] + 1;
                        q.offer(new int[] {x, y+1, 1});
                    }
                    if (dist[x][y][0] == -1) {
                        dist[x][y][0] = dist[x][y][1] + 1;
                        q.offer(new int[] {x, y, 0});
                    }
                }
            }
        }
        return dist[n-1][n-2][0];
    }

}
