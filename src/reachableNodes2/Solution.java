package reachableNodes2;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2024/3/2 下午8:24
 */
public class Solution {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] f = new List[n];
        for (int i = 0; i < n; i++) {
            f[i] = new ArrayList<>();
        }
        Set<Integer> set = new HashSet<>();
        for (int i : restricted) {
            set.add(i);
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            f[a].add(b);
            f[b].add(a);
        }

        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            res += 1;
            for (int next : f[cur[0]]) {
                if (!set.contains(next) && next != cur[1]){
                    q.offer(new int[]{next, cur[0]});
                }
            }
        }
        return res;
    }

}
