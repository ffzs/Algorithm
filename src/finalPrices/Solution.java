package finalPrices;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/9/1 下午1:28
 */
public class Solution {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            int cur = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= cur) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

}
