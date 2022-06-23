package findSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/6/23 下午5:01
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        int cnt = words.length, len = words[0].length();
        int n = s.length(), wl = len * cnt;
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int c = 0;
        for (int i = 0; i < len; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            c = 0;
            for (int j = i; j + len <= n; j+=len) {
                String cur = s.substring(j, j + len);
                if (!map.containsKey(cur)) {
                    tmp.clear();
                    c = 0;
                    continue;
                }
                tmp.put(cur, tmp.getOrDefault(cur, 0) + 1);
                c += 1;
                if (c > cnt) {
                    String first = s.substring(j - wl, j - wl + len);
                    tmp.put(first, tmp.get(first) - 1);
                    c -= 1;
                    if (tmp.get(first) == 0) {
                        tmp.remove(first);
                        continue;
                    }
                    if (!tmp.get(first).equals(map.get(first))) continue;
                }

                if (!tmp.get(cur).equals(map.get(cur))) continue;
                if (c == cnt && tmp.equals(map)) res.add(j - wl + len);
            }
        }
        return res;
    }
}
