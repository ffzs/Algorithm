package combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/10 上午7:16
 */
public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    int [] candidates;
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(this.candidates);
        this.n = candidates.length;
        dfs(target, 0, new ArrayList<>());
        return res;
    }

    private void dfs (int target, int start, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n; i++) {
            if (target >= candidates[i] && (i == start || candidates[i] != candidates[i-1])) {
                list.add(candidates[i]);
                dfs(target-candidates[i], i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
