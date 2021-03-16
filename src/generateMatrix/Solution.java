package generateMatrix;

/**
 * @author: ffzs
 * @Date: 2021/3/16 上午7:51
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, left = 0, right = n-1, bottom = n-1;
        int x = 1;

        while (true) {
            for (int i = left; i <= right; i++) res[top][i] = x++;
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) res[i][right] = x++;
            if (left > --right) break;
            for (int i = right; i >= left; i--) res[bottom][i] = x++;
            if (top > --bottom) break;
            for (int i = bottom; i >= top; i--) res[i][left] = x++;
            if (++left > right) break;
        }

        return res;
    }

}
