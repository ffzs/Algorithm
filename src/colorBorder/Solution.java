package colorBorder;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/12/7 上午7:29
 */
public class Solution {

    private int[][] grid;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int m, n;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int preColor = grid[row][col];
        dfs (row, col, color, preColor);
        for (int[] ints : this.grid) {
            for (int i = 0; i < n; i++) {
                if (ints[i] == -1) ints[i] = preColor;
                else if (ints[i] == 0) ints[i] = color;
            }
        }
        return this.grid;
    }

    private int dfs (int row, int col, int color, int preColor) {
        if (!isValid(row, col)) return 0;
        if (grid[row][col] != preColor) {
            if (grid[row][col] <= 0) return 1;
            else return 0;
        }
        grid[row][col] = -1;
        int ret = 1;
        for (int[] dir : dirs) {
            if (dfs(row + dir[0], col + dir[1], color, preColor) > 0) ret++;
        }
        if (ret <= 4) grid[row][col] = 0;
        return ret;
    }

    private boolean isValid (int row, int col) {
        return row >=0 && col >= 0 && row < m && col < n;
    }

}

class Test {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.colorBorder(grid, 1, 1, 2)));
    }
}
