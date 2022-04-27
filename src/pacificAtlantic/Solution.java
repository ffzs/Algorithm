package pacificAtlantic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/4/27 上午8:32
 */
public class Solution {

    int m, n;
    int[][] height;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.height = heights;
        m = heights.length; n = heights[0].length;
        boolean[][] pa = new boolean[m][n];
        boolean[][] at = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pa);
            dfs(i, n-1, at);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i, pa);
            dfs(m-1, i, at);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pa[i][j] && at[i][j]) res.add(List.of(i, j));
            }
        }
        return res;
    }

    private void dfs (int x, int y, boolean[][] ocean) {
        if (ocean[x][y]) return;

        ocean[x][y] = true;
        for (int[] dir : directions) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (isValid(xx, yy) && height[xx][yy] >= height[x][y]) dfs(xx, yy, ocean);
        }
    }

    private boolean isValid (int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
