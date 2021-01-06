package calcEquation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/1/6 下午8:37
 */
public class Solution2 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();

        int index = 0;
        for (List<String> equation : equations) {
            for (String s : equation) {
                if(!map.containsKey(s)) map.put(s, index++);
            }
        }

        int n = map.size();
        double[][] tmp = new double[n][n];

        for (int i = 0; i < values.length; i++) {
            List<String> lst = equations.get(i);
            String a = lst.get(0), b = lst.get(1);
            int ai = map.get(a), bi = map.get(b);
            tmp[ai][bi] = values[i];
            tmp[bi][ai] = 1/values[i];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) tmp[i][j] = 1D;
                    else if (tmp[i][k] != 0 && tmp[k][j] != 0) {
                        tmp[i][j] = tmp[i][k] * tmp[k][j];
                    }
                }
            }
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            List<String> lst = queries.get(i);
            String c = lst.get(0), d = lst.get(1);
            if (map.containsKey(c) && map.containsKey(d)) {
                int ci = map.get(c), di = map.get(d);
                res[i] = tmp[ci][di] != 0? tmp[ci][di]: -1;
            }
            else res[i] = -1;
        }

        return res;
    }

}
