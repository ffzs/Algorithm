package largestLocal;

/**
 * @author: ffzs
 * @Date: 2023/3/1 上午9:02
 */
public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                int maxV = 0;
                for (int x = i; x <= i + 2; x++) {
                    for (int y = j; y <= j + 2; y++) {
                        maxV = Math.max(maxV, grid[x][y]);
                    }
                }
                res[i][j] = maxV;
            }
        }
        return res;
    }

}
