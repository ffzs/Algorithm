package calcEquation;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/1/6 下午7:40
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> set = new HashSet<>();
        Map<String, Double> map = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            List<String> lst = equations.get(i);
            String k = lst.get(0) + "-" + lst.get(1);

            set.addAll(lst);
            map.put(k, values[i]);
            if (values[i] != 0) {
                String kr = lst.get(1) + "-" + lst.get(0);
                map.put(kr, 1/values[i]);
            }
        }

        for (String k : set) {
            for (String i : set) {
                for (String j : set) {
                    String n1 = i + "-" + k, n2 = k + "-" + j;
                    if (map.containsKey(n1) && map.containsKey(n2))
                        map.put(i + "-" + j, map.get(n1) * map.get(n2));
                }
            }
        }

        double[] res = new double[queries.size()];

        for (int i = 0; i < res.length; i++) {
            List<String> lst = queries.get(i);
            String c = lst.get(0), d = lst.get(1);
            if (!set.contains(c)||!set.contains(d)) res[i] = -1D;
            else if (c.equals(d)) res[i] = 1D;
            else res[i] = map.getOrDefault(c + '-' + d, -1D);
        }

        return res;
    }
}
