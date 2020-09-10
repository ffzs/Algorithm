package combinationSum3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/11 上午7:00
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1, new ArrayList<>());
        return  res;
    }

    private void dfs (int k, int n , int start ,List<Integer> list) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i <= n) {
                list.add(i);
                dfs(k-1, n-i, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
