package sortItems;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/1/12 下午7:56
 */
public class Solution {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int len = group.length;
        for (int i = 0; i < group.length; i++) if (group[i] == -1) group[i] = m++;

        List<Integer>[] groupGraph = new ArrayList[m];
        int[] groupIdg = new int[m];
        for (int i = 0; i < m; i++) groupGraph[i] = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int gId = group[i];
            List<Integer> before = beforeItems.get(i);
            for (int bId : before) {
                if (group[bId] != gId) {
                    groupGraph[group[bId]].add(gId);
                    groupIdg[gId]++;
                }
            }
        }


        List<Integer> groupRank = topologicalSort(groupGraph, groupIdg, m);
        if (groupRank.size() == 0) return new int[0];

        List<Integer>[] itemGraph = new ArrayList[n];
        int[] itemIdg = new int[n];
        for (int i = 0; i < len; i++) itemGraph[i] = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j : beforeItems.get(i)) {
                itemGraph[j].add(i);
                itemIdg[i]++;
            }
        }


        List<Integer> itemRank = topologicalSort(itemGraph, itemIdg, n);
        if (itemRank.size() == 0) return new int[0];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : itemRank) {
            int gId= group[i];
            if (!map.containsKey(gId)) map.put(gId, new ArrayList<>());
            map.get(gId).add(i);
        }

        int[] res = new int[n];
        int i = 0;
        for (int gId : groupRank) {
            if (map.containsKey(gId)) {
                for (int id : map.get(gId)) {
                    res[i++] = id;
                }
            }
        }

        return res;
    }

    private List<Integer> topologicalSort(List<Integer>[] graph, int[] idg, int n) {
        List<Integer> ret = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) if (idg[i] == 0) queue.offer(i);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            ret.add(cur);
            for (int i : graph[cur]) {
                idg[i] --;
                if (idg[i] == 0) queue.offer(i);
            }
        }

        return ret.size() == n? ret: new ArrayList<>();
    }
}
