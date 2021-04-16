package isScramble;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/4/16 上午7:49
 */
public class Solution {

    int[][][] dp;
    char[] cs1, cs2;
    int n;
    public boolean isScramble(String s1, String s2) {
        cs1 = s1.toCharArray();
        cs2 = s2.toCharArray();
        n = cs1.length;
        dp = new int[n][n][n+1];
        return dfs(0, 0, n);
    }

    private boolean dfs (int i, int j, int len) {
        if (dp[i][j][len] != 0) return dp[i][j][len] == 1;

        if (arrayEquals(i,j,len)) {
            dp[i][j][len] = 1;
            return true;
        }

        int[] counter = new int[26];
        for (int k = 0; k < len; k++) {
            counter[cs1[i+k]-'a']++;
            counter[cs2[j+k]-'a']--;
        }
        for (int k : counter) {
            if (k != 0) {
                dp[i][j][len] = -1;
                return false;
            }
        }

        for (int k = 1; k < len; k++) {
            if (dfs(i,j,k) && dfs(i+k, j+k, len-k)) {
                dp[i][j][len] = 1;
                return true;
            }
            if (dfs(i,j + len-k, k) && dfs(i+k, j, len-k)) {
                dp[i][j][len] = 1;
                return true;
            }
        }
        dp[i][j][len] = -1;
        return false;
    }

    private boolean arrayEquals (int i, int j, int len) {
        for (int k = 0; k < len; k++) {
            if (cs1[i+k] != cs2[j+k]) return  false;
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        Solution s = new Solution();
        System.out.println(s.isScramble(s1, s2));
    }
}
