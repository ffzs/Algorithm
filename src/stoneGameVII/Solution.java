package stoneGameVII;

/**
 * @author: ffzs
 * @Date: 2024/2/3 下午4:53
 */
public class Solution {
    int[][] memo;
    int[] s;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] += s[i] + stones[i];
        }

        memo = new int[n][n];
        return dfs(0, n - 1);
    }

    private int dfs (int i, int j) {
        if (i == j) return 0;

        if (memo[i][j] > 0) return memo[i][j];

        int ret1 = s[j + 1] - s[i + 1] -dfs(i + 1, j);
        int ret2 = s[j] - s[i] - dfs(i, j-1);
        return memo[i][j] = Math.max(ret1, ret2);
    }

}
