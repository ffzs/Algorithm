package change;

/**
 * @author: ffzs
 * @Date: 2021/6/10 上午7:02
 */
public class Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        for (int coin : coins) {
            for (int i = coin; i < amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

}
