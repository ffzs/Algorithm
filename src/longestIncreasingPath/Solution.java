package longestIncreasingPath;

/**
 * @author: ffzs
 * @Date: 2020/7/26 上午7:46
 */
class Solution {
    int n, m;
    int[][] mtx, step;
    final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        n = matrix.length;
        m = matrix[0].length;
        mtx = matrix;
        step = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                max = Math.max(max, dfs(i, j));
            }
        }

        return max;
    }

    private int dfs (int i, int j) {
        if (step[i][j] != 0) return step[i][j];

        step[i][j] = 1;
        for (int[] direction : directions) {
            int ii = direction[0] + i;
            int jj = direction[1] + j;
            if(ii < n && ii >= 0 && jj < m && jj >=0 && mtx[ii][jj] > mtx[i][j]) {
                step[i][j] = Math.max(step[i][j], dfs(ii, jj) + 1);
            }
        }
        return step[i][j];
    }
}

class TestStep {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
        System.out.println(solution.longestIncreasingPath(matrix));
    }
}
