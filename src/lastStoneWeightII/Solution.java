package lastStoneWeightII;

/**
 * @author: ffzs
 * @Date: 2021/6/8 上午6:58
 */
public class Solution {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int bgSize = sum/2;
        boolean[] dp = new boolean[bgSize+1];

        dp[0] = true;

        for (int stone : stones) {
            for (int j = bgSize; j >= stone; j--) {
                dp[j] = dp[j] || dp[j-stone];
            }
        }

        for (int i = bgSize; i >= 0; i--) {
            if (dp[i]) return sum - i*2;
        }

        return 0;

    }

}
