package solveNQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/3 上午9:12
 */
public class Solution2 {
    char[][] step;
    List<List<String>> res = new ArrayList<>();
    boolean[] column, rightDown, leftDown;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.step = new char[n][n];
        this.column = new boolean[n];
        this.rightDown = new boolean[n*2-1];
        this.leftDown = new boolean[n*2-1];
        dfs(0);
        return res;
    }

    private void dfs (int r) {
        if (r==n){
            res.add(transTable());
            return;
        }
        Arrays.fill(step[r], '.');
        for (int i = 0; i < n; i++) {
            int right = r-i+n-1;
            int left = r+i;
            if (!column[i] && !rightDown[right] && !leftDown[left]) {
                step[r][i] = 'Q';
                column[i] = rightDown[right] = leftDown[left] = true;
                dfs(r+1);
                // 回溯
                step[r][i] = '.';
                column[i] = rightDown[right] = leftDown[left] = false;
            }
        }
    }

    private List<String> transTable () {
        List<String> ret = new ArrayList<>();
        for (char[] ints : step) {
            ret.add(new String(ints));
        }
        return ret;
    }
}
