package findCheapestPrice;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/8/24 上午6:52
 */
public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = (int)(1e4) * 101 + 1;
        int[][] dp = new int[k + 2][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, INF);
        }
        dp[0][src] = 0;
        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                dp[t][i] = Math.min(dp[t][i], dp[t-1][j] + cost);
            }
        }
        int res = INF;
        for (int t = 1; t <= k + 1; t++) {
            res = Math.min(res, dp[t][dst]);
        }
        return res == INF? -1:res;
    }

}
