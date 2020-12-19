package rotate2;

/**
 * @author: ffzs
 * @Date: 2020/12/19 上午8:35
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n / 2); i++) {
            swap(matrix, i, n-1-i);
        }

        for (int i = 0; i < (n - 1); i++) {
            for (int j=n-1; j>i; j--) {
                deepSwap(matrix, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int i2) {
        int[] tmp = matrix[i1];
        matrix[i1] = matrix[i2];
        matrix[i2] = tmp;
    }

    private void deepSwap(int[][] matrix, int x, int y){
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[y][x];
        matrix[y][x] = tmp;
    }
}
