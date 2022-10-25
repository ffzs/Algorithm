package shortestBridge;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/10/25 下午12:20
 */
public class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int n;
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        Queue<int[]> edges = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, edges);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        System.out.println(edges.size());
        int res = 1;
        while (!edges.isEmpty()) {
            int size = edges.size();
            for (int i = 0; i < size; i++) {
                int[] cur = edges.poll();
                int x = cur[0], y = cur[1];
                for (int[] dir : directions) {
                    int xx = dir[0] + x, yy = dir[1] + y;
                    if (isValid(xx, yy)) {
                        if (grid[xx][yy] == 0) {
                            grid[xx][yy] = 2;
                            edges.offer(new int[]{xx, yy});
                        }
                        else if (grid[xx][yy] == 1) return res;
                    }
                }
            }
            res += 1;
        }
        return res;
    }
    
    private void dfs (int[][] grid, int x, int y, Queue<int[]> edges) {
        if (grid[x][y] != 1) {
            if (grid[x][y] == 0) {
                grid[x][y] = 2;
                edges.offer(new int[]{x, y});
            }
            return;
        }
        grid[x][y] = 2;
        for (int[] dir : directions) {
            int xx = x + dir[0], yy = y + dir[1];
            if (isValid(xx, yy)){
                dfs(grid, xx, yy, edges);
            }
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

}
