package findMinHeightTrees;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/4/6 上午8:45
 */
public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        if (n == 2) return List.of(0,1);
        List<Integer> res = new ArrayList<>();
        List<Integer>[] lst;
        int[] cnt = new int[n];
        lst = new List[n];
        for (int i = 0; i < n; i++) lst[i] = new ArrayList<>();
        for (int[] edge : edges) {
            ++cnt[edge[0]];++cnt[edge[1]];
            lst[edge[0]].add(edge[1]);
            lst[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) queue.offer(i);
        }

        int remain = n;
        while (remain > 2) {
            int size = queue.size();
            remain -= size;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int v: lst[cur]) {
                    --cnt[v];
                    if (cnt[v] == 1) {
                        queue.offer(v);
                    }
                }
            }
        }

        while (!queue.isEmpty()) res.add(queue.poll());
        return res;
    }
}
