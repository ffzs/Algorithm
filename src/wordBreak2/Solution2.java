package wordBreak2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2020/11/1 下午12:21
 */
public class Solution2 {

    Map<Character, List<String>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    char[] seq;
    boolean[] step;
    public List<String> wordBreak(String s, List<String> wordDict) {
        seq = s.toCharArray();
        for (String s1 : wordDict) {
            Character f = s1.charAt(0);
            if (!map.containsKey(f)) map.put(f, new ArrayList<>());
            map.get(f).add(s1);
        }

        step = new boolean[seq.length + 1];
        step[0] = true;
        for (int i = 0; i < seq.length ; i++) {
            if (step[i] && map.containsKey(seq[i])){
                for (String s1 : map.get(seq[i])) {
                    if (isMatch(seq, s1, i)) {
                        step[i+s1.length()] = true;
                    }
                }
            }
        }
        if (step[seq.length]) dfs(0, new ArrayList<>());
        return res;
    }


    private void dfs (int i, List<String> list) {
        if (i == seq.length) {
            res.add(String.join(" ", list));
            return;
        }
        if (!map.containsKey(seq[i]) || !step[i]) return;
        for (String s1 : map.get(seq[i])) {
            int index = i+s1.length();
            if (index <= seq.length && step[index] && isMatch(seq, s1, i)) {
                list.add(s1);
                dfs(index, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isMatch (char[] seq, String s, int start) {
        if (start + s.length() > seq.length) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != seq[start+i]) return false;
        }
        return true;
    }
}
