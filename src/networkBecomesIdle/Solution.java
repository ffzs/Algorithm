package networkBecomesIdle;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/3/20 上午8:10
 */
public class Solution {

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] lst = new List[n];
        for (int i = 0; i < n; i++) {
            lst[i] = new ArrayList<>();
        }
        int[] minLink = new int[n];
        Arrays.fill(minLink, -1);
        for (int[] edge : edges) {
            lst[edge[0]].add(edge[1]);
            lst[edge[1]].add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int it : lst[cur]) {
                    if (it != 0 && minLink[it] == -1) {
                        minLink[it] = level;
                        q.offer(it);
                    }
                }
            }
            ++level;
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            int time = minLink[i] * 2;
            res = Math.max(res, time <= patience[i]? time: time * 2 - (time - 1) % patience[i] - 1);
        }
        return res + 1;
    }

}
