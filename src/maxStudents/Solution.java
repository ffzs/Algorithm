package maxStudents;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/12/26 下午8:18
 */
public class Solution {
    int[][] memo;
    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int[] f = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') f[i] |= 1<<j;
            }
        }
        memo = new int[m][1<<n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(m-1, f[m-1], f);
    }

    private int dfs (int i, int j, int[] f) {
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        if (i == 0) {
            if (j == 0) {
                return 0;
            }
            int lowB = j & -j;
            return memo[i][j] = dfs(i, j & ~(lowB*3), f) + 1;
        }

        int res = dfs(i-1, f[i-1], f);
        for (int s = j; s > 0; s = (s - 1) & j ) {
            if ((s & (s>>1)) == 0) {
                int t = f[i-1] & ~(s<<1 | s>>1);
                res = Math.max(res, dfs(i -1, t, f) + Integer.bitCount(s));
            }
        }
        return memo[i][j] = res;
    }

}
