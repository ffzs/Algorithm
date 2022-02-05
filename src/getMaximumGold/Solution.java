package getMaximumGold;

/**
 * @author: ffzs
 * @Date: 2022/2/5 上午8:26
 */
public class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int res = 0;
    boolean[][] step;
    int[][] g;
    int m, n;
    public int getMaximumGold(int[][] grid) {
        m = grid.length; n = grid[0].length;
        step = new boolean[m][n];
        g = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != 0) {
                    step[i][j] = true;
                    dfs(i, j, g[i][j]);
                    step[i][j] = false;
                }
            }
        }
        return res;
    }

    private void dfs (int x, int y, int total) {
        boolean flag = true;
        for (int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (isValid(xx, yy) && !step[xx][yy] && g[xx][yy] != 0) {
                step[xx][yy] = true;
                dfs(xx, yy, total + g[xx][yy]);
                step[xx][yy] = false;
                flag = false;
            }
        }
        if (flag && total > res) res = total;
    }

    private boolean isValid (int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
