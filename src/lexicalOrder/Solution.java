package lexicalOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/4/18 上午8:07
 */
public class Solution {
    List<Integer> res = new ArrayList<>();
    int n;
    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        for (int i = 1; i <= 9; i++) {
            dfs(i);
        }
        return res;
    }

    private void dfs (int num) {
        if (num > n) return;

        res.add(num);
        num *= 10;
        for (int i = 0; i <= 9; i++) {
            if (num + i > n) break;
            dfs(num + i);
        }
    }

}
