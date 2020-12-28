package maxProfit4;

/**
 * @author: ffzs
 * @Date: 2020/12/28 下午8:02
 */


public class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        k = Math.min(k, n/2);

        int[] buy = new int[k + 1], sell = new int[k + 1];
        for (int i = 0; i <= k; i++) buy[i] = -prices[0];


        for (int i = 1; i < n; i++) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        int res = 0;
        for (int i : sell) {
            if (i > res) res = i;
        }
        return res;
    }
}
