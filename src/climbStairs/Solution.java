package climbStairs;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/29
 */
public class Solution {
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }
}
