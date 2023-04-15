package gardenNoAdj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/4/15 下午9:40
 */
public class Solution {

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            adj[path[0]-1].add(path[1]-1);
            adj[path[1]-1].add(path[0]-1);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[5];
            for (int it : adj[i]) {
                if (res[it] != 0) visited[res[it]] = true;
            }

            for (int j = 1; j <= 4; j++) {
                if (!visited[j]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }

}
