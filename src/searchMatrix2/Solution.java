package searchMatrix2;

/**
 * @author: ffzs
 * @Date: 2021/10/25 上午7:14
 */
public class Solution {
    int[][] matrix;
    int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        return search(0, matrix[0].length-1);
    }

    private boolean search(int row, int col) {
        if (row >= matrix.length) return false;
        for (int i = col; i >= 0; i--) {
            int cur = matrix[row][i];
            if (cur == target) return true;
            else if (cur < target) return search(row + 1, i);
        }
        return false;
    }

}
