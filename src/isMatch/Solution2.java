package isMatch;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/20
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        boolean[][] dp = new boolean[sChar.length+1][pChar.length+1];
        dp[0][0] = true;
        for (int i = 0; i < pChar.length; ++i) {
            if (pChar[i] == '*') dp[0][i+1] = dp[0][i-1];
        }
        for (int i = 1; i <= sChar.length; ++i) {
            for (int j = 1; j <= pChar.length; ++j) {
                if (pChar[j-1] == '*') {
                    if (pChar[j-2] == '.' || pChar[j-2] == sChar[i-1]) dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    else dp[i][j] = dp[i][j-2];
                }
                else {
                    if (pChar[j-1] == '.' || pChar[j-1] == sChar[i-1]) dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[sChar.length][pChar.length];
    }
}
