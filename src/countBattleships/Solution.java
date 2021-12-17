package countBattleships;

/**
 * @author: ffzs
 * @Date: 2021/12/18 上午7:44
 */
public class Solution {

    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && (j == 0 || board[i][j-1] != 'X') && (i == 0 || board[i-1][j] != 'X')) res++;
            }
        }
        return res;
    }
}
