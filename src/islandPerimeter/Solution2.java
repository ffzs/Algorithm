package islandPerimeter;

/**
 * @author: ffzs
 * @Date: 2020/10/30 上午10:08
 */
public class Solution2 {

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int c = 0, lr = 0, ud = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    c++;
                    if (j+1<m && grid[i][j+1] == 1) lr++;
                    if (i+1<n && grid[i+1][j] == 1) ud++;
                }
            }
        }
        return c*4 - (lr+ud) * 2;
    }
}
