package orderOfLargestPlusSign;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/11/9 下午1:05
 */
public class Solution {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (n * n == mines.length) return 0;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (grid[i][j] != 0 ){
                    grid[i][j] = grid[i][j-1] + 1;
                }
            }
            for (int j = n-2; j >= 1; --j) {
                if (grid[i][j] != 0 ){
                    grid[i][j] = Math.min(grid[i][j+1] + 1, grid[i][j]);
                }
            }
        }

        int res = 1, count;

        for (int j = 1; j < n - 1; j++) {
            count = grid[0][j];
            for (int i = 1; i < n - 1; i++) {
                if (grid[i][j] != 0) {
                    count += 1;
                    grid[i][j] = Math.min(grid[i][j], count);
                }
                else count = 0;
            }

            count = grid[n-1][j];
            for (int i = n-2; i >= 1; --i) {
                if (grid[i][j] != 0) {
                    count += 1;
                    grid[i][j] = Math.min(grid[i][j], count);
                    res = Math.max(res, grid[i][j]);
                }
                else count = 0;
            }
        }

        return res;
    }

}
