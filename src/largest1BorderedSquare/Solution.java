package largest1BorderedSquare;

import kotlin.jvm.internal.MagicApiIntrinsics;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/2/17 上午8:17
 */
public class Solution {

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = grid[0][0];
        int[][][] tmp = new int[m][n][2];
        tmp[0][0] = new int[]{grid[0][0], grid[0][0]};
        for (int i = 1; i < n; i++) {
            if (grid[0][i] == 1) {
                tmp[0][i] = new int[] {1, tmp[0][i-1][1] + 1};
                res = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            if (grid[i][0] == 1) {
                tmp[i][0] = new int[] {tmp[i-1][0][0] + 1, 1};
                res = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                tmp[i][j] = new int[]{tmp[i-1][j][0] + 1, tmp[i][j-1][1] + 1};
                int t = Math.min(tmp[i][j][0], tmp[i][j][1]);
                for (; t > res; --t) {
                    if (tmp[i-t+1][j][1]>=t && tmp[i][j-t+1][0]>=t) {
                        res = t;
                        break;
                    }
                }
            }
        }
        return res * res;
    }
}
