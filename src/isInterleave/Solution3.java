package isInterleave;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/7/18 上午9:42
 */
public class Solution3 {
    static boolean[][] dp;
    static int l1, l2, l3;
    static char[] c1, c2, c3;
    public static boolean isInterleave(String s1, String s2, String s3) {
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        if (l1 + l2 != l3) return false;
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        c3 = s3.toCharArray();
        dp = new boolean[l1+1][l2+1];
        return isMatch(0,0,0);
    }

    private static boolean isMatch (int i, int j, int k) {
        if (dp[i][j] || i > l1 || j > l2 ) return false;
        if (l1 == i && l2 == j) return true;
        if (i<l1 && c1[i] == c3[k] && isMatch(i+1,j,k+1)) return true;
        if (j<l2 && c2[j] == c3[k] && isMatch(i,j+1,k+1)) return true;
        dp[i][j] = true;
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
        System.out.println(Arrays.deepToString(dp));
    }

}
