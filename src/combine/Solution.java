package combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/8 上午7:04
 */

public class Solution {
    int n;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;

        dfs(k, new ArrayList<>());
        return res;
    }
    
    private void dfs (int k, List<Integer> list) {
        if (k==0) {
            res.add(new ArrayList<>(list));
            return;
        }
        int start = list.isEmpty()? 1: list.get(list.size()-1)+1;
        for (int i = start; i <= n-k+1; i++) {
            list.add(i);
            dfs(k-1, list);
            list.remove(list.size()-1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4,2));
    }
}
