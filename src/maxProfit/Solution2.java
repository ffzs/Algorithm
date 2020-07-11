package maxProfit;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/10
 */
public class Solution2 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[] dp = new int[3];
        dp[0] = -prices[0];
        // 0:持有 可触发买入动作和继续持有
        // 1:卖出进入冰冻期 可触发卖出动作进入冰冻期
        // 2:不持有股票不在冰冻期  可通过1转移而来进入非冰冻期
        for (int i = 1; i < len; i++) {
            int t0 = dp[0], t1 = dp[1], t2 = dp[2];
            dp[1] = t0 + prices[i];
            dp[0] = Math.max(t0, t2 - prices[i]);
            dp[2] = Math.max(t2, t1); // 由于上一轮为卖出状态处于冰冻期一定是收益有所增加即dp[i-1][1]>dp[i-1][2], 因此通过取max间接判断了是否为冰冻期
        }
        return Math.max(dp[1], dp[2]);
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
