package minCut;

/**
 * @author: ffzs
 * @Date: 2021/3/8 上午8:12
 */
public class Solution {

    int[][] f;
    int res = Integer.MAX_VALUE;
    int counter = 0;
    int n;

    public int minCut(String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);
        return res -1;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            res = Math.min(res, counter);
        }
        else {
            for (int j = n-1; j >= i; j--) {
                if (isValid(s, i, j) == 1 && counter < res) {
                    counter++;
                    dfs(s, j+1);
                    counter--;
                }
            }
        }
    }

    private int isValid(String s, int i, int j) {
        if (f[i][j] != 0) return f[i][j];

        if (i >= j) {
            f[i][j] = 1;
        }
        else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isValid(s, i+1, j-1);
        }
        else {
            f[i][j] = -1;
        }

        return f[i][j];
    }

}
