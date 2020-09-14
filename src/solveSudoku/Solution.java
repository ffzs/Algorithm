package solveSudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/15 上午6:19
 */
public class Solution {

    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] matrix = new boolean[3][3][9];
    List<int[]> blankList = new ArrayList<>();
    boolean ok = false;
    char[][] board;
    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char cur = board[i][j];
                if (cur=='.') {
                    blankList.add(new int[]{i,j});
                }
                else {
                    row[i][cur-'1'] = true;
                    col[j][cur-'1'] = true;
                    matrix[i/3][j/3][cur-'1'] = true;
                }
            }
        }
        dfs(0);
    }

    private void dfs (int index) {
        if (!ok) {
            if (index == blankList.size()) {
                ok = true;
                return;
            }
            int[] cur = blankList.get(index);
            int i = cur[0];
            int j = cur[1];
            for (int k = 0; k < 9; k++) {
                if (!row[i][k] && !col[j][k] && !matrix[i/3][j/3][k]) {
                    row[i][k] = col[j][k] = matrix[i/3][j/3][k] = true;
                    board[i][j] = (char)(k + '1');
                    dfs(index+1);
                    if (!ok) {
                        row[i][k] = col[j][k] = matrix[i/3][j/3][k] = false;
                    }
                }
            }
        }
    }
}
