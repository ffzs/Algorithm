package minCostClimbingStairs;

/**
 * @author: ffzs
 * @Date: 2020/12/21 上午8:27
 */
public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }


    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int a = cost[0], b = cost[1];
        for (int i = 2; i < n; i++) {
            int t = Math.min(a, b) + cost[i];
            a = b;
            b = t;
        }

        return Math.min(a, b);
    }

}
