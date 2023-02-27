package mergeSimilarItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2023/2/28 上午6:31
 */
public class Solution {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int[] ints : items1) {
            tm.put(ints[0], ints[1]);
        }

        for (int[] ints : items2) {
            tm.put(ints[0], tm.getOrDefault(ints[0], 0) + ints[1]);
        }
        List<List<Integer>> res = new ArrayList<>(tm.size());
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            res.add(List.of(entry.getKey(), entry.getValue()));
        }
        return res;
    }

}
