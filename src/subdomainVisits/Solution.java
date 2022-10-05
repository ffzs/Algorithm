package subdomainVisits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/10/5 上午11:31
 */
public class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            parse(s, map);
        }
        List<String> lst = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            lst.add(entry.getValue() + " " + entry.getKey());
        }
        return lst;
    }

    private void parse (String s, Map<String, Integer> map) {
        String[] tmp = new String[4];
        char[] cs = s.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (c == ' ' || c == '.') {
                tmp[i++] = sb.toString();
                sb = new StringBuilder();
                continue;
            }
            sb.append(c);
        }
        tmp[i] = sb.toString();
        int cnt = Integer.parseInt(tmp[0]);
        StringBuilder key = null;
        for (int j = 3; j >= 1; j-=1) {
            if (tmp[j] != null) {
                if (key == null) key = new StringBuilder(tmp[j]);
                else key.insert(0, tmp[j] + ".");
                map.put(key.toString(), map.getOrDefault(key.toString(), 0)  + cnt);
            }
        }
    }

}
