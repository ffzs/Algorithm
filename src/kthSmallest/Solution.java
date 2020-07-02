package kthSmallest;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/2
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] res = new int[matrix.length * matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                res[i*matrix.length + j] = matrix[j][i];
            }
        }
        Arrays.sort(res);
        return res[k-1];
    }
}
