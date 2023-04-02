package minScoreTriangulation;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/4/2 上午8:15
 */
public class Solution {
    int[][] memo;
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        memo = new int[n][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        return helper(values, 0, n - 1);
    }

    private int helper (int[] values, int i, int j) {
        if (i + 2 > j) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        if (i + 2 == j) return values[i] * values[i+1] * values[j];

        int ret = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            ret = Math.min(values[i] * values[j] * values[k] + helper(values, i, k) + helper(values, k, j), ret);
        }

        return memo[i][j] = ret;
    }

}
