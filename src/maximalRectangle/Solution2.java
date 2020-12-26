package maximalRectangle;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/12/26 上午11:27
 */
public class Solution2 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n);

        int res = 0;
        for (char[] chars : matrix) {
            int cur_lf = 0, cur_rg = n;
            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') height[j]++;
                else height[j] = 0;
            }

            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') left[j] = Math.max(left[j], cur_lf);
                else {
                    left[j] = 0;
                    cur_lf = j + 1;
                }
            }

            for (int j = n-1; j >= 0; j--) {
                if (chars[j] == '1') right[j] = Math.min(right[j], cur_rg);
                else {
                    right[j] = n;
                    cur_rg = j;
                }
            }

            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j]) * height[j]);
            }
        }

        return res;
    }
}
