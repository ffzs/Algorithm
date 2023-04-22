package longestArithSeqLength;

/**
 * @author: ffzs
 * @Date: 2023/4/22 下午12:00
 */
public class Solution {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, res = 0;
        int max = nums[0], min = max;
        for (int num : nums) {
            if (num > max) max = num;
            else if (num < min) min = num;
        }

        int diff = max - min;
        int[][] dp = new int[n][diff * 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                int d = nums[i] - nums[j] + diff;
                if (dp[i][d] == 0) {
                    dp[i][d] = dp[j][d] + 1;
                    res = Math.max(res, dp[i][d]);
                }
            }
        }
        return res;
    }

}
