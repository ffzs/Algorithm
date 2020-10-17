package totalNQueens;

/**
 * @author: ffzs
 * @Date: 2020/10/17 上午8:48
 */
public class Solution2 {

    int count = 0, n;
    public int totalNQueens(int n) {
        this.n = n;
        dfs(0,0,0,0);
        return count;
    }

    private void dfs (int row, int col, int left, int right) {
        if (row == n) {
            count++;
            return;
        }

        int available = ((1 << n) -1) & (~(col|left|right));
        while (available != 0) {
            int pos = -available & available;
            available -= pos;
            dfs(row+1, col|pos, (left|pos)<<1, (right|pos)>>1);
        }
    }
}
