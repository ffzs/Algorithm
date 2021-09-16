package isValidSudoku;

/**
 * @author: ffzs
 * @Date: 2021/9/17 上午6:48
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int idx = c - '0' -1;
                    int boxIdx = (i/3)*3 + j/3;
                    if (row[i][idx] >= 1 || col[j][idx] >= 1 || box[boxIdx][idx] >= 1) return false;
                    row[i][idx] ++;
                    col[j][idx] ++;
                    box[boxIdx][idx]++;
                }
            }
        }
        return true;
    }

}
