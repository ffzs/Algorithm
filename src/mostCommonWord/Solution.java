package mostCommonWord;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/4/17 上午8:21
 */
public class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        Set<String> bset = new HashSet<>(List.of(banned));
        Map<String, Integer> map = new HashMap<>();
        helper(paragraph, map);
        String res = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max && !bset.contains(entry.getKey()))  {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    private void dealWithRegex(String paragraph, Map<String, Integer> map){
        String[] ss = paragraph.split("[!?',;. ]");
        for (String s : ss) {
            if (s.isEmpty()) continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    private void helper (String paragraph, Map<String, Integer> map) {
        char[] cs = paragraph.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'a' && cs[i] <= 'z') {
                int s = i;
                while (i < cs.length && cs[i] >= 'a' && cs[i] <= 'z') ++i;
                String it = paragraph.substring(s, i);
                map.put(it, map.getOrDefault(it, 0) + 1);
            }
        }
    }

}
