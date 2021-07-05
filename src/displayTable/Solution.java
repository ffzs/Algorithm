package displayTable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: ffzs
 * @Date: 2021/7/6 上午6:51
 */
public class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> dish = new TreeSet<>();
        Set<Integer> table = new TreeSet<>();
        Map<String, Map<String, Integer>> map = new HashMap<>();

        for (List<String> order : orders) {
            String t = order.get(1), d = order.get(2);
            if (!map.containsKey(t)) map.put(t, new HashMap<>());
            Map<String, Integer> tmp = map.get(t);
            tmp.put(d, tmp.getOrDefault(d, 0) + 1);
            dish.add(d);
            table.add(Integer.valueOf(t));
        }
        List<List<String>> res = new ArrayList<>();
        List<String> first = new ArrayList<>(){{add("Table");}};
        first.addAll(dish);
        res.add(first);

        for (Integer it : table) {
            String s = String.valueOf(it);
            List<String> lst = new ArrayList<>();
            lst.add(s);
            int[] tmp = new int[dish.size()];
            Map<String, Integer> subMap = map.get(s);
            int i = 0;
            for (String d : dish) {
                tmp[i++] += subMap.getOrDefault(d, 0);
            }

            for (int j : tmp) {
                lst.add(String.valueOf(j));
            }
            res.add(lst);
        }
        return res;
    }

}
