package highestPeak;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/1/29 上午8:20
 */
public class Solution {

    static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m, n;
    public int[][] highestPeak(int[][] isWater) {
        m = isWater.length;
        n = isWater[0].length;
        int[][] height = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 0) height[i][j] = -1;
                else q.offer(new int[]{i,j});
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                int v = height[x][y];
                for (int[] dir : directions) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (!isValid(xx, yy)) continue;
                    if (height[xx][yy] == -1) {
                        height[xx][yy] = v + 1;
                        q.offer(new int[] {xx, yy});
                    }
                }
            }
        }
        return height;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
