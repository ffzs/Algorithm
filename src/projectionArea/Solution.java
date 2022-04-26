package projectionArea;

/**
 * @author: ffzs
 * @Date: 2022/4/26 上午8:20
 */
public class Solution {

    public int projectionArea(int[][] grid) {
        int n = grid.length;

        int res = 0;
        for (int i = 0; i < n; ++i) {
            int maxRow = 0, maxCol = 0;
            for (int j = 0; j < n; j++) {
                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
                if (grid[i][j] != 0) ++res;
            }
            res += maxRow + maxCol;
        }

        return res;
    }
}
