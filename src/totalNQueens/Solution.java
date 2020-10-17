package totalNQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/10/17 上午7:45
 */

public class Solution {

    int res = 0;
    boolean[] column, rightDown, leftDown;
    int n;

    public int totalNQueens(int n) {
        this.n = n;
        this.column = new boolean[n];
        this.rightDown = new boolean[n*2-1];
        this.leftDown = new boolean[n*2-1];
        dfs(0);
        return res;
    }

    private void dfs (int r) {
        if (r==n){
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int right = r-i+n-1;
            int left = r+i;
            if (!column[i] && !rightDown[right] && !leftDown[left]) {
                column[i] = rightDown[right] = leftDown[left] = true;
                dfs(r+1);
                // 回溯
                column[i] = rightDown[right] = leftDown[left] = false;
            }
        }
    }
}
