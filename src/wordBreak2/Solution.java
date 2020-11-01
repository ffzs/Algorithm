package wordBreak2;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/11/1 上午9:15
 */
public class Solution {

    Map<Character, List<String>> map = new HashMap<>();
    char[] seq;
    public List<String> wordBreak(String s, List<String> wordDict) {
        seq = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (String s1 : wordDict) {
            Character f = s1.charAt(0);
            if (!map.containsKey(f)) map.put(f, new ArrayList<>());
            map.get(f).add(s1);
            for (char c : s1.toCharArray()) {
                set.add(c);
            }
        }

        for (char c : seq) {
            if (!set.contains(c)) return new ArrayList<>();
        }

        boolean[] step = new boolean[seq.length +1];
        step[0] = true;
        Map<Integer, List<String>> tmp = new HashMap<>();
        tmp.put(seq.length, new ArrayList<>());
        for (int i = 0; i < seq.length ; i++) {
            if (step[i] && map.containsKey(seq[i])){
                for (String s1 : map.get(seq[i])) {
                    if (isMatch(seq, s1, i)) {
                        int index = i+s1.length();
                        if (!tmp.containsKey(index)) tmp.put(index, new ArrayList<>());
                        if (i==0) tmp.get(index).add(s1);
                        else {
                            for (String s2 : tmp.get(i)) {
                                tmp.get(index).add(s2 + " " + s1);
                            }
                        }
                        step[i+s1.length()] = true;
                    }
                }
            }
        }
        System.out.println(tmp);
        return tmp.get(seq.length);
    }

    private boolean isMatch (char[] seq, String s, int start) {
        if (start + s.length() > seq.length) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != seq[start+i]) return false;
        }
        return true;
    }
}
