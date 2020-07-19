package maxCoins;

/**
 * @author: ffzs
 * @Date: 2020/7/19 上午10:43
 */
public class Solution3 {
    public static int maxCoins(int[] nums) {

        int len = nums.length;
        if (len == 0) return 0;
        int[] ns = new int[len + 2];
        System.arraycopy(nums, 0, ns, 1, len);
        ns[0] = ns[len+1] = 1;
        int[][] dp = new int[len+2][len+2];

        for (int i = 2; i<len+2; i++) {
            for (int j = 0; j <= len + 1; ++j) {
                if (dp[i][j] == 0) {
                    for (int mid = i+1; mid < j; ++mid) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][mid]+dp[mid][j]+ns[i]*ns[j]*ns[mid]);
                    }
                }
            }
        }
        return dp[0][len+1];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoins(nums));
    }
}
