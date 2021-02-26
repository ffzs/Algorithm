package findNumOfValidWords;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: ffzs
 * @Date: 2021/2/26 上午8:11
 */
public class Solution {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Map<String, Set<Integer>>> map = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < puzzles.length; i++) {
            String puzzle = puzzles[i];
            indexMap.put(puzzle, i);
            char[] chars = puzzle.toCharArray();
            int cur = chars[0] - 'a';
            if (!map.containsKey(cur)) map.put(cur, new HashMap<>());
            Map<String, Set<Integer>> subMap = map.get(cur);
            if (!subMap.containsKey(puzzle)) subMap.put(puzzle, new HashSet<>());
            Set<Integer> set = subMap.get(puzzle);
            for (char c : chars) {
                set.add(c - 'a');
            }
        }
        Integer[] res = new Integer[puzzles.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < words.length; i++) {
            boolean[] tmp = new boolean[26];
            char[] cs = words[i].toCharArray();
            for (int c : cs) {
                tmp[c - 'a'] = true;
            }
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] && map.containsKey(j)) {
                    Map<String, Set<Integer>> subMap = map.get(j);
                    for (Map.Entry<String, Set<Integer>> e : subMap.entrySet()) {
                        if (check(tmp, e.getValue())) res[indexMap.get(e.getKey())] ++;
                    }
                }
            }

        }

        return Arrays.stream(res).collect(Collectors.toList());
    }

    private boolean check (boolean[] tmp, Set<Integer> set) {
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] && !set.contains(i)) return false;
        }
        return true;
    }

}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(solution.findNumOfValidWords(words, puzzles));
    }
}
