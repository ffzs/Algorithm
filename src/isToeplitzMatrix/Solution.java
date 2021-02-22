package isToeplitzMatrix;

/**
 * @author: ffzs
 * @Date: 2021/2/22 下午4:56
 */
public class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < n - 1; i++) {
            int cur = matrix[0][i];
            for (int j = 1; j < m; j++) {
                if (i + j < n && matrix[j][j + i] != cur) return false;
            }
        }

        for (int i = 1; i < m - 1; i++) {
            int cur = matrix[i][0];
            for (int j = 1; j < n; j++) {
                if (i + j < m && matrix[i + j][j] != cur) return false;
            }
        }
        return true;
    }
}
