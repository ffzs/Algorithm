package NumMatrix;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/3/2 上午8:31
 */
public class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        this.sum = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) this.sum[i][j] = matrix[i][j];
                else this.sum[i][j] = this.sum[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = 0;
        if (col1 == 0) {
            for (int i = row1; i <= row2; i++) {
                ret += this.sum[i][col2];
            }
        }
        else {
            for (int i = row1; i <= row2; i++) {
                ret += this.sum[i][col2] - this.sum[i][col1 - 1];
            }
        }
        return ret;
    }
}

