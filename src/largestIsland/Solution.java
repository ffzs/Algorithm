package largestIsland;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/9/18 下午2:20
 */
public class Solution {
    int[][] grid, visited, directions = {{1,0}, {0,-1}, {-1,0}, {0,1}};
    int n;
    List<Integer> cnt;
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.visited = new int[n][n];
        cnt = new ArrayList<>();
        cnt.add(-1);
        int id = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    cnt.add(dfs(i, j, id++));
                }
            }
        }
        int res = 0;
        for (int i = 0; i < id; i++) {
            res = Math.max(res, cnt.get(i));
        }
        res = Math.min(n * n, res + 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, unionArea(i, j));
                }
            }
        }
        return res;
    }

    private int unionArea (int x, int y) {
        int area = 1;
        Set<Integer> set = new HashSet<>();
        for (int[] dir : directions) {
            int xx = x + dir[0], yy = y + dir[1];
            if (!isValid(xx, yy)) continue;
            int id = visited[xx][yy];
            if (id != 0 && !set.contains(id)) {
                set.add(id);
                area += cnt.get(id);
            }
        }
        return area;
    }

    private int dfs (int x, int y, int id) {
        visited[x][y] = id;
        int ret = 1;
        for (int[] dir : directions) {
            int xx = x + dir[0], yy = y + dir[1];
            if (isValid(xx, yy) && grid[xx][yy] == 1 && visited[xx][yy] == 0 ) {
                ret += dfs(xx, yy, id);
            }
        }
        return ret;
    }

    private boolean isValid (int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

}
