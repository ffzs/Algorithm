package luckyNumbers;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/2/15 上午8:37
 */
public class Solution {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] row = new int[m], col = new int[n];
        Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = matrix[i][j];
                if (cur < row[i]) row[i] = cur;
                if (cur > col[j]) col[j] = cur;
            }
        }

        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : row) {
            set.add(i);
        }
        for (int i : col) {
            if (set.contains(i)) res.add(i);
        }
        return res;
    }

}
