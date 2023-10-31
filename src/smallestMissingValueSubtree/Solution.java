package smallestMissingValueSubtree;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/10/31 上午8:58
 */
public class Solution {

    List<Integer>[] g;
    Set<Integer> vis;
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        g = new List[n];
        vis = new HashSet<>();
        Arrays.setAll(g, a->new ArrayList<>());
        int[] res = new int[n];
        Arrays.fill(res, 1);

        for (int i = 1; i < parents.length; i++) {
            g[parents[i]].add(i);
        }

        int node = 0;
        while (node < n && nums[node] != 1) node++;
        if (node == n) return res;
        int mg = 2;

        while (node != -1) {

            dfs(node, nums);
            while (vis.contains(mg)) mg++;
            res[node] = mg;
            node = parents[node];
        }

        return res;
    }

    private void dfs (int node, int[] nums) {
        vis.add(nums[node]);
        for (int next : g[node]) {
            if(!vis.contains(nums[next])) dfs(next, nums);
        }
    }

}
