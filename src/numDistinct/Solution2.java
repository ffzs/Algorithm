package numDistinct;

/**
 * @author: ffzs
 * @Date: 2021/3/17 上午7:53
 */
public class Solution2 {

    public int numDistinct(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int m = sc.length, n = tc.length;
        if (m < n) return 0;

        int[][] f = new int[m+1][n+1];
        for (int[] ints : f) {
            ints[n] = 1;
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                f[i][j] = sc[i] == tc[j]?f[i+1][j+1] + f[i+1][j]:f[i+1][j];
            }
        }

        return f[0][0];
    }

}
