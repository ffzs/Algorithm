package maxProfit2;

/**
 * @author: ffzs
 * @Date: 2020/11/8 上午7:16
 */

public class Solution {

    public int maxProfit(int[] prices) {
        int i = 0, res = 0;
        while (i < prices.length) {
            int start = i;
            while (i + 1 < prices.length && prices[i] < prices[i+1]) {
                i++;
            }

            if (start != i) {
                res += (prices[i] - prices[start]);
            }
            i++;
        }
        return res;
    }
}
