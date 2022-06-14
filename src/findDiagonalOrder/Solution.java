package findDiagonalOrder;

import java.security.KeyStore;

/**
 * @author: ffzs
 * @Date: 2022/6/14 下午5:03
 */
public class Solution {
    int m, n;
    public int[] findDiagonalOrder(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int[] res = new int[m * n];
        int idx = 0, t = 0;
        for (int i = 0; i < n; i++) {
            int s = idx;
            for (int j = 0; j <= i && j < m; j++) {
                res[idx++] = mat[j][i-j];
            }
            if (t % 2 == 0) swap(res, s, idx-1);
            t += 1;
        }

        for (int i = 1; i < m; i++) {
            int s = idx;
            for (int j = 0; n-1-j >= 0 && j + i < m; j++) {
                res[idx++] = mat[j+i][n-1-j];
            }
            if (t % 2 == 0) swap(res, s, idx-1);
            t += 1;
        }

        return res;
    }

    private void swap (int[] res, int s, int i) {
        while (s < i) {
            int tmp = res[s];
            res[s] = res[i];
            res[i] = tmp;
            s += 1;
            i -= 1;
        }
    }
}