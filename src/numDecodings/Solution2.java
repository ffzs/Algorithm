package numDecodings;

/**
 * @author: ffzs
 * @Date: 2021/4/21 上午10:11
 */
public class Solution2 {
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (cs[i] != '0') dp[i+1] = dp[i];
            if (i-1>=0 && (cs[i-1] == '1' || cs[i-1] == '2' && cs[i] <= '6')) dp[i+1] += dp[i-1];
        }
        return dp[n];
    }
}
