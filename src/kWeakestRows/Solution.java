package kWeakestRows;

import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2021/8/1 上午10:14
 */
public class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        boolean[] visited = new boolean[mat.length];
        int i = 0, col = 0;
        while (i < k && col < mat[0].length) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][col] == 0 && !visited[j]) {
                    res[i++] = j;
                    if (i >= k) break;
                    visited[j] = true;
                }
            }
            col ++;
        }
        for (int j = 0; j < mat.length && i < k; j++) {
            if (!visited[j]) res[i++] = j;
        }
        return res;
    }

}
