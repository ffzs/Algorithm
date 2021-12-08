package maxSumOfThreeSubarrays;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/12/8 上午7:40
 */
public class Solution {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] tmp = new int[n - k + 1];
        for (int i = 0; i < tmp.length; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    tmp[0] += nums[j];
                }
            }
            else tmp[i] = tmp[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        int[][] dp = new int[4][n+1];

        for (int i = 1; i < 4; i++) {
            for (int j = i * k; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-k] + tmp[j-k]);
            }
        }

        int[] res = new int[3];
        int idx = n;
        for (int i = 2; i >= 0; i--) {
            int j = idx;
            while (idx > 0 && dp[i+1][j] == dp[i+1][idx]) idx--;
            res[i] = idx - k +1;
            idx -= k - 1;
        }
        return res;
    }

}

class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,6,7,5,1};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.maxSumOfThreeSubarrays(nums, 2)));
    }
}
