package combinationSum;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/9/9 上午7:02
 */

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int [] candidates;
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.n = candidates.length;
        dfs(target, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void dfs (int target, int start, List<Integer> list) {

        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        else if (target > 0) {
            for (int i = start; i < n; i++) {
                if (target >= candidates[i]) {
                    list.add(candidates[i]);
                    dfs(target-candidates[i], i, list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
