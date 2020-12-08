package generate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/12/6 下午12:47
 */

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        List<Integer> pre = new ArrayList<>(List.of(1));
        res.add(pre);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>(pre.size()+1);
            cur.add(1);
            for (int j = 1; j < pre.size(); j++) {
                cur.add(pre.get(j-1)+pre.get(j));
            }
            cur.add(1);
            res.add(cur);
            pre = cur;
        }
        return res;
    }
}
