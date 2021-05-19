package kthLargestValue;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/5/19 下午2:28
 */
public class Solution {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] tmp = new int[m + 1][n + 1];

        int[] val = new int[m * n];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tmp[i][j] = tmp[i - 1][j] ^ tmp[i][j - 1] ^ tmp[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                val[(i - 1) * n + j - 1] = tmp[i][j];
            }
        }
        Arrays.sort(val);
        return val[val.length - k];
    }

}
