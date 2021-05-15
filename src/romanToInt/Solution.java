package romanToInt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/5/15 上午8:06
 */
public class Solution {

    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        final Map<Character, Integer> map = new HashMap<>() {{
            put('M', 1000);
            put('D', 500);
            put('C', 100);
            put('L', 50);
            put('X', 10);
            put('V', 5);
            put('I', 1);
        }};

        int i = 0, res = 0;
        while (i < cs.length) {
            if (i + 1 >= cs.length) res += map.get(cs[i]);
            else {
                if ((cs[i] == 'C' && (cs[i + 1] == 'M' || cs[i + 1] == 'D')) || (cs[i] == 'X' && (cs[i + 1] == 'C' || cs[i + 1] == 'L')) || (cs[i] == 'I' && (cs[i + 1] == 'X' || cs[i + 1] == 'V'))) {
                    res = res - map.get(cs[i]) + map.get(cs[i++ + 1]);
                } else res += map.get(cs[i]);
            }
            i++;
        }

        return res;
    }

}
