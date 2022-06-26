package pickBlackList;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: ffzs
 * @Date: 2022/6/26 上午9:40
 */
public class Solution2 {
    Map<Integer, Integer> map;
    int white;
    Random r = new Random();
    public Solution2(int n, int[] blacklist) {
        map = new HashMap<>();
        white = n - blacklist.length;

        for (int i : blacklist) {
            map.put(i, 0);
        }

        int end = n - 1;
        for (int i : blacklist) {
            if (i >= white) continue;
            while (map.containsKey(end)) end -= 1;
            map.put(i, end);
            end -= 1;
        }
    }

    public int pick() {
        int i = r.nextInt(white);
        if (map.containsKey(i)) return map.get(i);
        return i;
    }


}
