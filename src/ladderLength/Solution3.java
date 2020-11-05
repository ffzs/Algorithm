package ladderLength;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/11/5 上午11:28
 */
public class Solution3 {

    Set<String> wordSet;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> start = new HashSet<>();
        start.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);

        return dfs(start, end, 2);
    }


    private int dfs (Set<String> start, Set<String> end, int level) {
        if (start.size() == 0) return 0;
        if (start.size()>end.size()) return dfs(end, start, level);

        wordSet.removeAll(start);
        Set<String> nextLevel = new HashSet<>();
        for (String s : start) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char cur = chars[i];
                for (char c='a'; c<='z'; c++) {
                    if (c == cur) continue;
                    chars[i] = c;
                    String next = new String(chars);
                    if (wordSet.contains(next)) {
                        if (end.contains(next)) return level;
                        else nextLevel.add(next);
                    }
                }
                chars[i] = cur;
            }
        }
        return dfs(nextLevel, end, level+1);
    }

}
