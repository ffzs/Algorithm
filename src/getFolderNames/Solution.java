package getFolderNames;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2023/3/3 上午6:28
 */
public class Solution {

    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] res = new String[n];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(names[i])) {
                map.put(names[i], 1);
                res[i] = names[i];
            }
            else {
                int idx = map.get(names[i]);
                while (map.containsKey(combine(names[i], idx))) idx += 1;
                res[i] = combine(names[i], idx);
                map.put(res[i], 1);
                map.put(names[i], idx + 1);
            }
        }
        return res;
    }

    private String combine (String s, int i) {
        return new StringBuilder().append(s).append('(').append(i).append(')').toString();
    }

}
