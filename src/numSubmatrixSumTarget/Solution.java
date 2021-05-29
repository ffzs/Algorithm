package numSubmatrixSumTarget;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/5/29 上午8:46
 */
public class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int[][] tmp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tmp[i][j] = tmp[i-1][j] + tmp[i][j-1] + matrix[i-1][j-1] - tmp[i-1][j-1];
            }
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int ii = 0; ii < i; ii++) {
                    for (int jj = 0; jj < j; jj++) {
                        if ((tmp[i][j] + tmp[ii][jj] - tmp[i][jj] - tmp[ii][j]) == target) res++;
                    }
                }
            }
        }

        return res;
    }

}
