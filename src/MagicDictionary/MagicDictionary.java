package MagicDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/7/11 下午12:32
 */

public class MagicDictionary {

    Map<Integer, List<String>> map;
    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int len = s.length();
            if (!map.containsKey(len)) map.put(len, new ArrayList<>());
            map.get(len).add(s);
        }
    }

    public boolean search(String searchWord) {
        int n = searchWord.length();
        if (!map.containsKey(n)) return false;
        for (String s : map.get(n)) {
            if (compare(s, searchWord)) return true;
        }
        return false;
    }

    private boolean compare (String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt += 1;
                if (cnt > 1) return false;
            }

        }
        return cnt == 1;
    }

}
