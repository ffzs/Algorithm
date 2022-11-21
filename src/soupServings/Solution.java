package soupServings;

/**
 * @author: ffzs
 * @Date: 2022/11/21 下午4:39
 */
public class Solution {
    int[][] types = {{4, 0}, {3, 1}, {2, 2}, {1, 3}};
    double[][] memo;
    public double soupServings(int n) {
        n = (int)Math.ceil((double)n/25);
        if (n >= 179) return 1D;
        memo = new double[n+1][n+1];
        return dfs(n, n);
    }

    private double dfs (int A, int B) {
        if (A <= 0 && B <= 0) return 0.5;
        else if (A <= 0) return 1;
        else if (B <= 0) return 0;
        if (memo[A][B] != 0) return memo[A][B];
        double ret = 0;
        for (int[] t : types) {
            ret += dfs(A - t[0], B - t[1]);
        }
        return memo[A][B] = ret/4;
    }

}
