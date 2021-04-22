package maxSumSubmatrix;

/**
 * @author: ffzs
 * @Date: 2021/4/22 上午11:24
 */
public class Solution2 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for (int x = 0; x < n; x++) {
            int[] sum = new int[m];
            for (int i = x; i < n; i++) {
                for (int y = 0; y < m; y++) {
                    sum[y] += matrix[y][i];
                }
                int max = Integer.MIN_VALUE, cur = 0;
                for (int s : sum) {
                    cur = Math.max(cur+s, s);
                    max = Math.max(max, cur);
                    if (max == k) return max;
                }

                if (max < k) res = Math.max(res, max);
                else {
                    for (int y = 0; y < m; y++) {
                        int rowSum = 0;
                        for (int j = y; j < m; j++) {
                            rowSum += sum[j];
                            if (rowSum == k) return k;
                            else if (rowSum < k && rowSum > res) res = rowSum;
                        }
                    }
                }
            }
        }
        return res;
    }
}
