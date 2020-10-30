package islandPerimeter;

/**
 * @author: ffzs
 * @Date: 2020/10/30 上午9:32
 */

public class Solution {

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] dir : directions) {
                    if (grid[i][j] == 0) continue;
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii < 0 || ii >= n || jj < 0 || jj >= m || grid[ii][jj] == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
