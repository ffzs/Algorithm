package sumOfDistancesInTree;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/10/6 上午7:06
 */
public class Solution {

    Map<Integer, Integer> distanceMap;
    Map<Integer, Integer> countMap;
    List<List<Integer>> tree;
    List<List<Integer>> tree2;
    int[] res;
    boolean[] mark;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        res = new int[N];
        if (N == 1) return res;
        distanceMap = new HashMap<>();
        countMap = new HashMap<>();
        tree = new ArrayList<>();
        tree2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
            tree2.add(new ArrayList<>());
        }
        int root = 0;
        mark = new boolean[N];
        mark[root] = true;
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs(root);
        res[root] = distanceMap.get(root);

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int baseSum = res[cur];
                for (Integer integer : tree2.get(cur)) {
                    int subNode = countMap.get(integer);
                    res[integer] = baseSum - subNode + (N - subNode - 2);
                    queue.add(integer);
                }
            }
        }
        return res;
    }

    private int[] dfs (int root) {
        int[] ret = new int[2];
        for (Integer integer : tree.get(root)) {
            if (!mark[integer]) {
                mark[integer] = true;
                tree2.get(root).add(integer);
                int[] subRet =dfs(integer);
                ret[1] += subRet[1];
                ret[0] += subRet[0];
                ret[0] ++;
            }
        }
        ret[1] += ret[0];
        countMap.put(root, ret[0]);
        distanceMap.put(root, ret[1]);
        return ret;
    }
}

class Test {
    public static void main(String[] args) {
//        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
//        int[][] edges = {{2,1}, {0,2}};
        int[][] edges = {{1,2}, {3,2}, {3, 0}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sumOfDistancesInTree(4, edges)));
    }
}
