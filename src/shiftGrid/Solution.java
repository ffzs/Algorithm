package shiftGrid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/7/20 上午8:45
 * 0 - 4 == -4 + 16 == 12
 */
public class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, tt = m * n;
        k %= tt;
        List<List<Integer>> res = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<Integer> lst = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                int it = (i * n + j - k + tt) % tt;
                int x = it / n, y = it % n;
                lst.add(grid[x][y]);
            }
            res.add(lst);
        }
        return res;
    }

}
