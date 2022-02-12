package numEnclaves;

/**
 * @author: ffzs
 * @Date: 2022/2/12 上午8:36
 */
public class Solution2 {

    int m, n;
    int[][] g;
    int[][] dirs = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
    public int numEnclaves(int[][] grid) {
        g = grid;
        m = g.length;
        n = g[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            helper(i, 0);
            helper(i, n-1);
        }

        for (int i = 0; i < n; i++) {
            helper(0, i);
            helper(m-1, i);
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1) res ++;
            }
        }
        return res;
    }

    private void helper (int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n && g[i][j] == 1) {
            g[i][j] = 0;
            for (int[] dir : dirs) {
                helper(i + dir[0], j + dir[1]);
            }
        }
    }

}
