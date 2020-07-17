package calculateMinimumHP;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/12
 */
public class Solution {
    public static int calculateMinimumHP(int[][] dungeon) {
        int y = dungeon.length, x = dungeon[0].length;
        int[][] dp = new int[y+1][x+1];
        for (int i = 0; i < x; i++) dp[y][i] = Integer.MAX_VALUE;
        for (int i = 0; i < y; i++) dp[i][x] = Integer.MAX_VALUE;
        dp[y][x-1] = 1;
        for (int j = x-1; j >= 0; --j) {
            for (int i = y-1; i >= 0; --i) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5,-10,1}, {10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}
