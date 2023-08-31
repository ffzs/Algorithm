package minTrioDegree;

/**
 * @author: ffzs
 * @Date: 2023/8/31 上午7:58
 */
public class Solution2 {

    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] g = new boolean[n][n];
        int[] degree = new int[n];

        for (int[] e : edges) {
            int a = e[0]-1, b = e[1]-1;
            g[a][b] = g[b][a] = true;
            degree[a]++;
            degree[b]++;
        }

        int res = Integer.MAX_VALUE;
        for (int a = 0; a < n; a++) {
            for (int b = a+1; b < n; b++) {
                if (g[a][b]) {
                    for (int c = b+1; c < n; c++) {
                        if (g[a][c] && g[b][c]) {
                            res = Math.min(res, degree[a] + degree[b] + degree[c]);
                        }
                    }
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res-6;
    }

}
