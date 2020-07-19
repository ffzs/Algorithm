package maxCoins;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/7/19 上午10:16
 */
public class Solution2 {
    public static int maxCoins(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] ns = new int[len + 2];
        System.arraycopy(nums, 0, ns, 1, len);
        ns[0] = ns[len+1] = 1;
        int[][] dp = new int[len+2][len+2];

        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 2; j <= len + 1; ++j) {
                if (dp[i][j] == 0) {
                    int max = 0;
                    for (int mid = i+1; mid < j; ++mid) {
                        max = Math.max(max, dp[i][mid]+dp[mid][j]+ns[i]*ns[j]*ns[mid]);
                    }
                    dp[i][j] = Math.max(dp[i][j], max);
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
