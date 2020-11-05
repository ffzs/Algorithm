package ladderLength;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/11/5 上午9:42
 */
public class Solution2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        int min = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        char[][] iChar = new char[beginWord.length()][26];
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

        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean flag = false;
        int level = 1;

        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                assert word != null;
                char[] chars = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char tmp = chars[j];
                    for (char ch : iChar[j])  {
                        if (ch==0) break;
                        chars[j] = ch;
                        if (tmp == ch) continue;
                        String str = new String(chars);
                        if (wordSet.contains(str) && !visited.contains(str)) {
                            if (str.equals(endWord)) {
                                flag = true;
                                min = Math.min(min, level+1);
                            }
                            else subVisited.add(str);
                            queue.add(str);
                        }
                    }
                    chars[j] = tmp;
                }
            }
            visited.addAll(subVisited);
            level++;
        }

        return min == Integer.MAX_VALUE?0:min;
    }

}
