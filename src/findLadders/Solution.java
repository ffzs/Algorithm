package findLadders;

import java.util.*;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/7
 */
public class Solution {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> distSet = new HashSet<>(wordList);
        if (!distSet.contains(endWord)) return res;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String[]> queue = new LinkedList<>();
        String[] ls = {beginWord};
        queue.add(ls);
        boolean flag = false;
        int level = 0;
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String[] route = queue.poll();
                assert route != null;
                String word = route[level];
                char[] chars = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char tmp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch ++) {
                        chars[j] = ch;
                        if (tmp == ch) continue;
                        String str = new String(chars);
                        if (distSet.contains(str) && !visited.contains(str)) {
                            String[] routeNext = Arrays.copyOf(route, level+2);
                            routeNext[level+1] = str;
                            if (str.equals(endWord)) {
                                flag = true;
                                res.add(List.of(routeNext));
                            }
                            else subVisited.add(str);
                            queue.add(routeNext);
                        }
                    }
                    chars[j] = tmp;
                }
            }
            visited.addAll(subVisited);
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        String begin="red", end = "tax";
        String[] strs = {"ted","tex","red","tax","tad","den","rex","pee"};
        List<String> list = List.of(strs);
        System.out.println(findLadders(begin, end, list));
    }
}
