package isMatch2;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/5
 */
public class Solution {
    public static boolean isMatch(String s, String p) {
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        boolean[][] dp = new boolean[sChar.length+1][pChar.length+1];
        dp[0][0] = true;
        for (int i = 0; i <= sChar.length; ++i) {
            for (int j = 1; j <= pChar.length; ++j) {
                if (i == 0) {
                    if (pChar[j-1] == '*') dp[i][j] = dp[i][j-1];
                }
                else {
                    if (pChar[j-1] == '*') {
                        if (dp[i - 1][j - 1] || dp[i-1][j] || dp[i][j-1]) dp[i][j] = true;
                    }
                    else {
                        if (pChar[j-1] == '?' || pChar[j-1] == sChar[i-1]) dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[sChar.length][pChar.length];
    }

    public static void main(String[] args) {
        String s = "cab";
        String p = "*";
        System.out.println(isMatch(s, p));
    }
}

