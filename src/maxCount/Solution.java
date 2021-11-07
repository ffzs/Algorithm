package maxCount;

/**
 * @author: ffzs
 * @Date: 2021/11/7 上午7:50
 */
public class Solution {

    public int maxCount(int m, int n, int[][] ops) {

        int col = m, row = n;
        for (int[] op : ops) {
            col = Math.min(op[0], col);
            row = Math.min(op[1], row);
        }

        int res = col * row;
        return res == 0? 1: res;
    }

}
