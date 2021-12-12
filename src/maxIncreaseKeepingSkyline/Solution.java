package maxIncreaseKeepingSkyline;

/**
 * @author: ffzs
 * @Date: 2021/12/13 上午7:45
 */
public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m], col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(row[i], col[j]) - grid[i][j];
            }
        }

        return res;
    }

}
