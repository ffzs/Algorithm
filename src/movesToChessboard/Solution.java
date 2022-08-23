package movesToChessboard;

/**
 * @author: ffzs
 * @Date: 2022/8/23 上午10:42
 */
public class Solution {

    public int movesToChessboard(int[][] board) {
        int n = board.length, rowCnt = 0, colCnt = 0;
        for (int i = 0; i < n; i++) {
            rowCnt += board[0][i];
            colCnt += board[i][0];
        }
        if (n % 2 == 1) {
            if (Math.abs(n - 2 * rowCnt) != 1 ) return -1;
            if (Math.abs(n - 2 * colCnt) != 1 ) return -1;
        }
        else {
            if (2 * rowCnt != n || 2 * colCnt != n) return -1;
        }

        int mask = (1 << n) - 1;
        int firstRow = encodeRow(board, 0), firstCol = encodeCol(board, 0);
        for (int i = 1; i < n; i++) {
            int row = encodeRow(board, i);
            if ((row ^ firstRow) != mask && row != firstRow) return -1;
            int col = encodeCol(board, i);
            if (col != firstCol && (col ^ firstCol) != mask) return -1;
        }

        int mCol = 0, mRow = 0;
        for (int i = 0; i < n; i++) {
            if (board[0][i] != i % 2) mRow += 1;
            if (board[i][0] != i % 2) mCol += 1;
        }

        if (n % 2 == 0) {
            return (Math.min(mRow, n - mRow) + Math.min(mCol, n - mCol)) / 2;
        }
        else {
            if (rowCnt != n / 2) mRow = n - mRow;
            if (colCnt != n / 2) mCol = n - mCol;
            return (mRow + mCol) / 2;
        }
    }

    private int encodeRow(int[][] board, int row) {
        int ret = 0;
        for (int i : board[row]) {
            ret <<= 1;
            ret |= i;
        }
        return ret;
    }

    private int encodeCol(int[][] board, int col) {
        int ret = 0;
        for (int[] ints : board) {
            ret <<= 1;
            ret |= ints[col];
        }
        return ret;
    }

}
