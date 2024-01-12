package countWords;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2024/1/12 下午7:51
 */
public class Solution {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        for (String s : words1) {
            m1.put(s, m1.getOrDefault(s, 0) + 1);
        }

        for (String s : words2) {
            m2.put(s, m2.getOrDefault(s, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            if (entry.getValue() == 1 && m2.getOrDefault(entry.getKey(), 0) == 1) res += 1;
        }

        return res;
    }

}
