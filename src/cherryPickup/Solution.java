package cherryPickup;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/7/10 上午8:58
 */
public class Solution {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }

        dp[0][0] = grid[0][0];
        int val;
        for (int k = 1; k < n * 2 - 1; k+=1) {
            for (int x1 = Math.min(k, n - 1); x1 >= Math.max(k-n+1, 0); x1-=1) {
                for (int x2 = Math.min(k, n - 1); x2 >= x1; x2-=1) {
                    int y1 = k - x1, y2 = k - x2;
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        dp[x1][x2] = Integer.MIN_VALUE;
                        continue;
                    }

                    val = dp[x1][x2];
                    if (x1 > 0) {
                        val = Math.max(val, dp[x1-1][x2]);
                    }
                    if (x2 > 0) {
                        val = Math.max(val, dp[x1][x2-1]);
                    }
                    if (x1 > 0 && x2 > 0) {
                        val = Math.max(val, dp[x1-1][x2-1]);
                    }
                    val += grid[x1][y1];
                    if (x1 != x2) val += grid[x2][y2];
                    dp[x1][x2] = val;
                }
            }
        }
        return Math.max(dp[n - 1][n - 1], 0);
    }

}
