package maxProfit5;

/**
 * @author: ffzs
 * @Date: 2021/1/9 上午8:41
 */
public class Solution2 {

    public int maxProfit(int[] prices) {
        int buy1 = -prices[0], buy2 = -prices[0], sell1 = 0, sell2 = 0;
        for (int cur : prices) {
            if (buy1 < -cur) buy1 = -cur;
            if (sell1 < buy1 + cur) sell1 = buy1 + cur;
            if (buy2 < sell1 - cur) buy2 = sell1 - cur;
            if (sell2 < buy2 + cur) sell2 = buy2 + cur;
        }
        return sell2;
    }
}
