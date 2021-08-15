package findPaths;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/8/15 上午7:04
 * 通过maxMove剪枝的深度优先搜索
 * return条件 到达边界或是到达 move上限
 */

public class Solution {

    int[][][] visited;
    final int MOD = 1_000_000_007;
    int m, n, N;
    int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        N = maxMove;
        visited = new int[m][n][N+1];
        for (int[][] ints : visited) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs(startRow, startColumn, 0);
    }

    private int dfs(int row, int col, int s){
        if (s == N) return isOut(row, col)? 1: 0;
        if (isOut(row, col)) return 1;
        if (visited[row][col][s] != -1) return visited[row][col][s];
        int sum = 0;
        for (int[] dir : dirs) {
            sum += dfs(row + dir[0], col + dir[1], s + 1);
            if (sum >= MOD) sum -= MOD;
        }
        return visited[row][col][s] = sum;
    }

    private boolean isOut(int row, int col) {
        return row >= m || row < 0 || col >= n || col < 0;
    }

}
