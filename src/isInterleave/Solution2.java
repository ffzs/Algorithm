package isInterleave;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/7/18 上午8:45
 */
public class Solution2 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();

        if (l1 + l2 != l3) return false;

        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for (int i = 0; i < l1+1; ++i) {
            for (int j = 0; j < l2+1; ++j) {
                int k = i + j - 1;
                if (i == 0 && j == 0) continue;
                else if (i > 0 && j == 0) dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(k);
                else if (i == 0)  dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(k);
                else dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(k)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(k));
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
