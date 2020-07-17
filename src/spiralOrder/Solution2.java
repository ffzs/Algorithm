package spiralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/5
 */
public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix.length == 0) return new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> res = new ArrayList<>(matrix.length * matrix[0].length);
        while(true) {
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            if(++top > bottom) break;
            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            if(left > --right) break;
            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            if(top > --bottom) break;
            for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            if(++left > right) break;
        }
        return res;
    }
}
