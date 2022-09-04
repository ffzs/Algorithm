package numSpecial;

/**
 * @author: ffzs
 * @Date: 2022/9/4 下午1:12
 */
public class Solution {

    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rows[i] += 1;
                    cols[j] += 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            if (rows[i] == 1) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1 && cols[j] == 1) {
                        res += 1;
                        break;
                    }
                }
            }
        }

        return res;
    }
}
