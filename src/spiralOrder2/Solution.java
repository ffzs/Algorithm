package spiralOrder2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/3/15 上午9:22
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new ArrayList<>();
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m*n);

        int left = 0, top = 0, right = n - 1, bottom = m - 1;

        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            if (left > --right) break;
            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            if (top > --bottom) break;
            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }

        return res;
    }

}
