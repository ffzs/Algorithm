package maxTaxiEarnings;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/12/8 上午9:08
 */
public class Solution {

    public long maxTaxiEarnings(int n, int[][] rides) {
        int[] earns = new int[rides.length];
        Arrays.sort(rides, (a, b) -> a[1]-b[1]);
        for (int i = 0; i < earns.length; i++) {
            earns[i] = rides[i][1] + rides[i][2] - rides[i][0];
        }
        long[] dp = new long[n+1];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1];
            while (idx < rides.length && rides[idx][1] == i) {
                dp[i] = Math.max(dp[i], dp[rides[idx][0]] + earns[idx]);
                idx++;
            }
        }
        return dp[n];
    }

}
