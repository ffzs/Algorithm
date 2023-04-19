package maxSumAfterPartitioning;

/**
 * @author: ffzs
 * @Date: 2023/4/19 上午8:59
 */
public class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i < k) {
                max = Math.max(max, arr[i-1]);
                dp[i] = max * i;
                continue;
            }
            int j = i - 1;
            max = arr[j];
            for (; j >= 0 && j >= i - k ; --j) {
                dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                if (j != 0) max = Math.max(arr[j-1], max);
            }
        }
        return dp[n];
    }

}
