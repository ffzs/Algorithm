package uniquePathsWithObstacles;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/6
 */
public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int y = obstacleGrid.length;
        int x = obstacleGrid[0].length;
        int[][] dp = new int[y+1][x+1];
        dp[0][1] = 1;
        System.out.println(Arrays.deepToString(dp));
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (obstacleGrid[i][j] == 0){
                    dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[y][x];
    }

    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
        int[][] obstacleGrid = {{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
