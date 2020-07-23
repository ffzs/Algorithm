package minPathSum;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/7/23 上午7:50
 */
public class Solution {
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 2; i < m + 1; i++) dp[i][0] = Integer.MAX_VALUE;
        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
