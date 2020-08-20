package updateBoard;

/**
 * @author: ffzs
 * @Date: 2020/8/20 上午10:19
 */
public class Solution2 {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    int n, m;
    char[][] board;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.n = board.length;
        this.m = board[0].length;
        this.board = board;

        dfs(click[0], click[1]);
        return board;
    }

    private void dfs (int i, int j) {
        if (board[i][j] == 'M') board[i][j] = 'X';
        if (board[i][j] == 'E') {
            int count = 0;
            for (int[] dir : directions) {
                int ii = dir[0] + i;
                int jj = dir[1] + j;
                if (isValid(ii, jj) && board[ii][jj] == 'M') {
                    count++;
                }
            }
            if (count != 0) {
                board[i][j] = (char)(count + '0');
            }
            else{
                board[i][j] = 'B';
                for (int[] dir : directions)
                    if (isValid(i+dir[0], j+dir[1])) dfs(i+dir[0], j+dir[1]);
            }
        }
    }

    private boolean isValid (int ii, int jj) {
        return ii>=0 && ii < n && jj>=0 && jj < m;
    }
}
