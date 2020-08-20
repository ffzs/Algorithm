package updateBoard;

/**
 * @author: ffzs
 * @Date: 2020/8/20 上午8:57
 */

public class Solution {
    int[][] tmp;
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    int n, m;
    char[][] board;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.n = board.length;
        this.m = board[0].length;
        tmp = new int[n][m];
        this.board = board;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'M') {
                    tmp[i][j]++;
                    for (int[] dir : directions) {
                        int ii = dir[0] + i;
                        int jj = dir[1] + j;
                        if (isValid(ii, jj)) tmp[ii][jj]++;
                    }
                }
            }
        }
        dfs(click[0], click[1]);
        return board;
    }

    private void dfs (int i, int j) {
        if (tmp[i][j] > 0) {
            if (board[i][j] != 'M') board[i][j] = (char)(tmp[i][j] + '0');
            else board[i][j] = 'X';
        }
        else if (tmp[i][j] == 0) {
            tmp[i][j] = -1;
            if (board[i][j] == 'E') {
                board[i][j] = 'B';
                for (int[] dir : directions) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (isValid(ii, jj) && board[ii][jj] == 'E') dfs(ii, jj);
                }
            }
        }
    }

    private boolean isValid (int ii, int jj) {
        return ii>=0 && ii < n && jj>=0 && jj < m;
    }
}
