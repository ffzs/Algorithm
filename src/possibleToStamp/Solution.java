package possibleToStamp;

/**
 * @author: ffzs
 * @Date: 2023/12/14 上午9:47
 */
public class Solution {

    public boolean possibleToStamp(int[][] grid, int h, int w) {
        int m = grid.length, n = grid[0].length;

        int[][] cs = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cs[i][j] = cs[i-1][j] + cs[i][j-1] - cs[i-1][j-1] + grid[i-1][j-1];
            }
        }

        int[][] g = new int[m+2][n+2];
        int x, y;
        for (int i = 1; i + h - 1 <= m; i++) {
            x = i + h - 1;
            for (int j = 1; j + w - 1 <= n; j++) {
                y = j + w - 1;

                if (cs[x][y] - cs[x][j-1] - cs[i-1][y] + cs[i-1][j-1] == 0) {
                    g[i][j]++;
                    g[x+1][y+1]++;
                    g[x+1][j]--;
                    g[i][y+1]--;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] += g[i-1][j] + g[i][j-1] - g[i-1][j-1];
                if (grid[i-1][j-1] == 0 && g[i][j] == 0) return false;
            }
        }

        return true;
    }

}
