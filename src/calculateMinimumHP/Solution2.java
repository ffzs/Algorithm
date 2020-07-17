package calculateMinimumHP;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/12
 */
public class Solution2 {
    static int[][] dg, dp;
    static int x, y;
    public static int calculateMinimumHP(int[][] dungeon) {
        y = dungeon.length;
        x = dungeon[0].length;
        dg = dungeon;
        dp = new int[y][x];

        return dfs(0,0);
    }

    private static int dfs (int i, int j) {
        if (i == y - 1&&j == x - 1) return Math.max(1 - dg[i][j], 1);

        if (dp[i][j] != 0) return dp[i][j];

        if (i == y-1) dp[i][j] = Math.max(dfs(i,j+1)-dg[i][j], 1);
        else if (j == x - 1) dp[i][j] = Math.max(dfs(i+1,j)-dg[i][j], 1);
        else dp[i][j] = Math.max(Math.min(dfs(i+1,j), dfs(i, j+1))-dg[i][j], 1);

        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5,-10,1}, {10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}
