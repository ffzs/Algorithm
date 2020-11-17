package allCellsDistOrder;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/17 上午9:13
 */
public class Solution {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        res[0] = new int[]{r0, c0};
        boolean[][] tmp = new boolean[R][C];
        tmp[r0][c0] = true;
        int i = 1;
        int[][] direction = {{-1,1}, {1,1}, {-1,-1}, {1,-1}};
        for (int n = 1; n < Math.max(R-r0, r0) + Math.max(C-c0, c0); n++) {
            for (int j = 0; j <= n; j++) {
                for (int[] dir : direction) {
                    int ii = dir[0]*j+r0;
                    int jj = dir[1]*(n-j)+c0;
                    if (ii>=0 && ii<R && jj>=0 && jj<C && !tmp[ii][jj]) {
                        res[i++] = new int[]{ii,jj};
                        tmp[ii][jj] = true;
                    }
                }
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.allCellsDistOrder(3, 3, 0, 2)));
    }
}
