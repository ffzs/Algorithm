package findNumOfValidWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/2/26 上午10:10
 */
public class Solution2 {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            char[] cs = word.toCharArray();
            int mask = 0;
            for (char c : cs) {
                mask |= (1 << (c - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) map.put(mask, map.getOrDefault(mask, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (String puzzle : puzzles) {
            int counter = 0;
            char[] cs = puzzle.toCharArray();
            int mask = 0;
            for (int i = 1; i < cs.length; i++) {
                mask |= (1 << (cs[i] - 'a'));
            }

            int cur = mask;
            int head = (1 << (cs[0] - 'a'));
            do {
                int s = cur | head;
                if (map.containsKey(s)) counter += map.get(s);
                cur = (cur - 1) & mask;
            } while (cur != mask);

            res.add(counter);
        }
        return res;
    }

}
