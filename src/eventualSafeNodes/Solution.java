package eventualSafeNodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/8/5 上午6:54
 * 0 未被访问
 * 1 处于递归查找中
 * 2 安全
 */
public class Solution {
    int[] color;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();

        color = new int[n];

        for (int i = 0; i < n; i++) {
            if (isSafe(graph, i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSafe(int[][] graph, int i) {
        if (color[i] > 0) return color[i] == 2;

        color[i] = 1;
        for (int j : graph[i]) {
            if (!isSafe(graph, j)) return false;
        }
        color[i] = 2;
        return true;
    }
}
