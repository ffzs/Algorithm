package maxSumSubmatrix;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/4/22 上午9:54
 */
public class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] tmp = new int[m + 1][n + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int num = matrix[i - 1][j - 1];
                if (num == k) return k;
                else if (num < k && num > res) res = num;
                num += tmp[i - 1][j] + tmp[i][j - 1] - tmp[i - 1][j - 1];
                tmp[i][j] = num;
                if (num == k) return k;
                else if (num < k && num > res) res = num;
                for (int x = 1; x <= i; x++) {
                    for (int y = 1; y <= j; y++) {
                        if ((x == i && y == j) || (x == 1 && y == 1)) continue;
                        int cur = num - tmp[i][y - 1] - tmp[x - 1][j] + tmp[x - 1][y - 1];
                        if (cur == k) return k;
                        else if (cur < k && cur > res) res = cur;
                    }
                }
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] matrix = new int[1][3];
        matrix[0] = new int[]{2, 2, -1};
        Solution solution = new Solution();
        System.out.println(solution.maxSumSubmatrix(matrix, 0));
    }
}
