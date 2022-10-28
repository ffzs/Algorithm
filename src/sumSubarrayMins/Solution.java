package sumSubarrayMins;

/**
 * @author: ffzs
 * @Date: 2022/10/28 下午12:42
 */
public class Solution {
    static final int MOD = (int)1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        int[] stack = new int[n + 1];
        stack[0] = -1;
        dp[0] = 0;
        int res = 0, idx = 0;
        for (int i = 0; i < n; i++) {
            while (idx > 0 && arr[i] <= arr[stack[idx]]) idx -= 1;
            dp[i + 1] = (dp[stack[idx] + 1] + (i - stack[idx]) * arr[i]) % MOD;
            stack[++idx] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            res = (res + dp[i]) % MOD;
        }
        return res;
    }

}
