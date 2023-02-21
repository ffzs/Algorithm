package stoneGameII;

/**
 * @author: ffzs
 * @Date: 2023/2/22 上午6:31
 */
public class Solution {

    public int stoneGameII(int[] piles) {
        int n  = piles.length, m = 1, s = 1;
        while (s <= n) {
            m *= 2;
            s += m;
        }
        m = Math.min(m, n);
        int[][] dp = new int[n][m+1];
        int sum = 0;
        for (int i = n-1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= m; M++) {
                if (i + 2 * M >= n) dp[i][M] = sum;
                else {
                    int next = Integer.MAX_VALUE >> 1;
                    for (int x = 1; x <= Math.min(M * 2, m); x++) {
                        next = Math.min(next, dp[i+x][Math.max(x, M)]);
                    }
                    dp[i][M] = sum - next;
                }
            }
        }
        return dp[0][1];
    }
}
