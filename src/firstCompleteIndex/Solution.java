package firstCompleteIndex;

/**
 * @author: ffzs
 * @Date: 2023/12/1 上午9:52
 */
public class Solution {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];

        int[][] g = new int[m*n+1][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = mat[i][j];
                g[v] = new int[] {i, j};
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            if (++rows[g[v][0]] == n) return i;
            if (++cols[g[v][1]] == m) return i;
        }

        return -1;
    }
}
