package maxProfit;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/10
 */
public class Solution3 {
    public static int maxProfit(int[] prices) {
        int[] dp = new int[3];
        dp[0] = Integer.MIN_VALUE;
        for (int price : prices) {
            int t1 = dp[1];
            dp[1] = dp[0] + price;
            dp[0] = Math.max(dp[0], dp[2] - price);
            dp[2] = Math.max(dp[2], t1);
        }
        return Math.max(dp[1], dp[2]);
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
