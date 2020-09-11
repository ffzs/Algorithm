package combinationSum2;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/9/10 上午7:08
 */
public class Solution {
    Set<List<Integer>> res = new HashSet<>();
    int[] candidates;
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.n = candidates.length;
        dfs(target, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void dfs (int target, int start, List<Integer> list) {
        if (target == 0) {
            List<Integer> ret = new ArrayList<>(list);
            Collections.sort(ret);
            res.add(new ArrayList<>(ret));
        }

        else if (target > 0) {
            for (int i = start; i < n; i++) {
                if (target >= candidates[i]) {
                    list.add(candidates[i]);
                    dfs(target-candidates[i], i+1, list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
