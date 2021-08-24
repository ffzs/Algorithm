package allPathsSourceTarget;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/8/25 上午6:49
 */
public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        List<Integer> lst = new ArrayList<>();
        lst.add(0);
        dfs(graph, lst, 0);
        return res;
    }

    private void dfs(int[][] graph, List<Integer> lst, int i){
        if (i == n - 1) {
            res.add(new ArrayList<>(lst));
            return;
        }

        for (int j : graph[i]) {
            lst.add(j);
            dfs(graph, lst, j);
            lst.remove(lst.size()-1);
        }
    }

}
