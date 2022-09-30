package setZeroes2;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/9/30 上午9:37
 */
public class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] rows = new boolean[m], cols = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 0; i < cols.length; i++) {
            if (cols[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

}
