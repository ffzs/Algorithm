package numBusesToDestination;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/6/28 上午6:59
 */
public class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (target == source) return 0;

        int n = routes.length;

        boolean[][] edges = new boolean[n][n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int l : routes[i]) {
                List<Integer> lst = map.getOrDefault(l, new ArrayList<>());
                for (int j : lst) {
                    edges[i][j] = edges[j][i] = true;
                }
                lst.add(i);
                map.put(l, lst);
            }
        }

        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();

        int res = Integer.MAX_VALUE;

        for (int l : map.getOrDefault(source, new ArrayList<>())) {
            visited[l] = 1;
            queue.offer(l);
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < n; j++) {
                if (edges[i][j] && visited[j] == -1) {
                    visited[j] = visited[i] + 1;
                    queue.offer(j);
                }
            }
        }

        for (int l : map.getOrDefault(target, new ArrayList<>()))
            if (visited[l] != -1 && visited[l] < res) res = visited[l];

        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
