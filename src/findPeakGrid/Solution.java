package findPeakGrid;

/**
 * @author: ffzs
 * @Date: 2023/12/19 上午8:51
 */
public class Solution {

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int l = 0, h = m - 1;
        while (l < h) {
            int x = (l + h) >> 1;
            int maxV = 0, y = 0;
            for (int i = 0; i < n; i++) {
                if (mat[x][y] > maxV) {
                    maxV = mat[x][y];
                    y = i;
                }
            }

            if (x > 0 && maxV < mat[x-1][y]) {
                h = x - 1;
            }
            else if (x + 1 < m && maxV < mat[x+1][y]) {
                l = x + 1;
            }
            else {
                return new int[]{x,y};
            }
        }

        return new int[0];
    }

}
