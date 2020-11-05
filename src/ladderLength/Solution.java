package ladderLength;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/11/5 上午7:53
 */

public class Solution {
    char[][] iChar;
    Set<String> wordSet;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        iChar = new char[beginWord.length()][26];
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (String s : wordList) {
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(i)) map.put(i, new HashSet<>());
                map.get(i).add(s.charAt(i));
            }
        }

        for (int i = 0; i < beginWord.length(); i++) {
            int j = 0;
            for (Character c : map.get(i)) {
                iChar[i][j++] = c;
            }
        }

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
                for (char c : iChar[i]) {
                    if (c == 0) break;
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordList = new ArrayList<>(List.of("hot","dot","dog","lot","log","cog"));
        String beginWord="hit", endWord = "cog";
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}
