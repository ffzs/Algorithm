package solve;

/**
 * @author: ffzs
 * @Date: 2020/8/11 上午7:52
 */
public class Solution {
    int[][] step;
    char[][] board;
    int m, n;
    int[][] directions = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) return;
        n = board[0].length;
        this.board = board;

        step = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || i==m-1 || j==0 || j==n-1) {
                    if (board[i][j] == 'O') findO(i,j);
                    else step[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && step[i][j] != -1) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void findO(int i, int j) {
        step[i][j] = -1;
        for (int[] dir : directions) {
            int ii = dir[0] + i;
            int jj = dir[1] + j;
            if (isValid(ii, jj) && step[ii][jj]==0 && board[ii][jj] == 'O') {
                findO(ii, jj);
            }
        }
    }

    private boolean isValid (int ii, int jj) {
        return ii>=0 && ii<m && jj>=0 && jj<n;
    }
}
