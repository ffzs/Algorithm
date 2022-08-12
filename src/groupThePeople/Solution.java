package groupThePeople;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/8/12 上午11:24
 */
public class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List[] map = new ArrayList[groupSizes.length+1];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int k = groupSizes[i];
            if(map[k] == null) map[k] = new ArrayList();
            map[k].add(i);
            if (map[k].size() == k) {
                res.add(map[k]);
                map[k] = new ArrayList();
            }
        }
        return res;
    }

}
