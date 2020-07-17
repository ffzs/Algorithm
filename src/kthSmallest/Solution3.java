package kthSmallest;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/2
 */
public class Solution3 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + right >> 1;
            if (countLeft(matrix, mid) < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private int countLeft(int[][] matrix, int mid) {
        int count = 0;
        int j = 0;
        for (int i = matrix.length - 1; i >= 0; --i) {
            while (j < matrix.length && matrix[i][j] <= mid) j++;
            count += j;
        }
        return count;
    }
}
