package maxProfit3;

/**
 * @author: ffzs
 * @Date: 2020/12/17 上午8:46
 */
public class Solution2 {

    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
