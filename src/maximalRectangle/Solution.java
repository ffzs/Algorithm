package maximalRectangle;

/**
 * @author: ffzs
 * @Date: 2020/12/26 上午10:38
 */

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1'){
                    if (j == 0) tmp[i][j] = 1;
                    else tmp[i][j] = tmp[i][j-1] + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) continue;
                int width = tmp[i][j];
                res = Math.max(res, width);
                for (int k = i-1; k >= 0; k--) {
                    width = Math.min(width, tmp[k][j]);
                    res = Math.max(res, (i-k+1)*width);
                }
            }
        }
        return res;
    }
}
