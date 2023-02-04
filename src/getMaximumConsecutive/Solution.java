package getMaximumConsecutive;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/2/4 上午8:35
 */
public class Solution {

    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > res) return res;
            res += coin;
        }
        return res;
    }

}
